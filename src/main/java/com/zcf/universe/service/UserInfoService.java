package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.IDUtils;
import com.zcf.universe.common.utils.SmsUtils;
import com.zcf.universe.mapper.UserInfoMapper;
import com.zcf.universe.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by YuanQJ on 2018/10/31.
 */
@Slf4j
@Service

public class UserInfoService {
    //设置拦截图片的格式
    private static final List<String> ALLOW_TYPES = Arrays.asList("image/jpeg", "image/png", "image/jpg");

    //设置RedisKey的前缀
    private static final String PHONE_NUMBER = "PHONE_NUMBER:";

    @Autowired
    private UserInfoMapper userInfomapper;

    @Autowired
    private RedisTemplate redisTemplate;

    // 注册时的验证码
    public void getRegisterCode(String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
        UserInfo userInfo = this.checkPhone(phone);
        //如果信息不为空表示改手机号已被注册过
        if (userInfo != null) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_IS_REGISTERED);
        }
        String random = IDUtils.Random();//获取随机数
        SmsUtils.sendRegister(phone, random);//发送验证码
        //把验证码放入Redis中并设置3分钟的过期时间
        redisTemplate.opsForValue().set(PHONE_NUMBER + phone, random, 60 * 3, TimeUnit.SECONDS);
    }

    // 忘记密码时的验证码
    public void getForgetCode(String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
        //查询是否有此用户
        UserInfo userInfo = this.checkPhone(phone);
        //没有去注册
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.USER_IS_NOT_FOUND);
        }
        String random = IDUtils.Random();//获取随机数
        SmsUtils.sendRegister(phone, random);//发送验证码
        //把验证码放入Redis中并设置3分钟的过期时间
        redisTemplate.opsForValue().set(PHONE_NUMBER + phone, random, 60 * 3, TimeUnit.SECONDS);
    }

    //用户注册
    public void registerUser(String userPhoneNumber, String userPassword, String registerCode) {
        //获取手机号的验证码
        String code = (String) redisTemplate.opsForValue().get(PHONE_NUMBER + userPhoneNumber);
        if (!StringUtils.equals(code, registerCode)) {
            throw new CommonException(ExceptionEnum.REGISTER_CODE_MISMATCH);
        }
        UserInfo user = this.checkPhone(userPhoneNumber);
        //如果信息不为空表示改手机号已被注册过
        if (user != null) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_IS_REGISTERED);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNikeName("品家用户");
        userInfo.setUserPhoneNumber(userPhoneNumber);
        userInfo.setUserPassword(userPassword);
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        int insertSelective = this.userInfomapper.insertSelective(userInfo);
        if (insertSelective != 1) {
            throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }

    }

    //更新用户信息
    public void updateUser(UserInfo user, Integer id) {
        user.setUserId(id);
        int count = this.userInfomapper.updateByPrimaryKeySelective(user);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //用户登录
    public UserInfo loginUser(String userPhoneNumber, String userPassword) {
        //查询手机号是否存在
        UserInfo userInfo = this.checkPhone(userPhoneNumber);
        //查询用户是否存在
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.USER_IS_NOT_FOUND);
        }
        if (!StringUtils.equals(userInfo.getUserPassword(), userPassword)) {
            throw new CommonException(ExceptionEnum.USER_PASSWORD_MISMATCH);
        }
        return userInfo;
    }

    //上传用户的头像
    public void uploadUserHeadPortrait(Integer id, MultipartFile file) {
        //获取文件的路径
        String userImageUrl = this.uploadImage(file);
        UserInfo userInfo = this.userInfomapper.selectByPrimaryKey(id);
        userInfo.setUserHeadPortrait(userImageUrl);
        int count = userInfomapper.updateByPrimaryKeySelective(userInfo);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }
    }

    //上传图片返回图片的地址
    private String uploadImage(MultipartFile file) {
        try {
            //校验文件类型
            String contentType = file.getContentType();//获取文件的上传类型
            if (!ALLOW_TYPES.contains(contentType)) {
                throw new CommonException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //校验文件内容
            BufferedImage read = ImageIO.read(file.getInputStream());
            if (read == null) {
                throw new CommonException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //上传文件
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/";
            String customPath = "user/";//自定义图片存储路径
            return FileUploadUtils.fileUpload(file, path, customPath);
        } catch (IOException e) {
            log.error("上传文件失败", e);
            return null;
        }
    }

    //查看该用户是否已经实名认证0.未实名1.已实名
    public boolean isAuthentication(Integer id) {
        UserInfo userInfo = this.getUserInfo(id);
        int userState = userInfo.getUserState();
        return 1 == userState;
    }

    // 根据主键获取用户的信息
    public UserInfo getUserInfo(Integer id) {
        UserInfo userInfo = this.userInfomapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.USER_IS_NOT_FOUND);
        }
        return userInfo;
    }


    //修改用户密码
    public void updateUSerPasswords(String phone, String password, String forgetCode) {

        //验证是否为空
        if (StringUtils.isBlank(phone) && StringUtils.isBlank(password)) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //获取手机号的验证码
        String code = (String) redisTemplate.opsForValue().get(PHONE_NUMBER + phone);
        if (!StringUtils.equals(code, forgetCode)) {
            throw new CommonException(ExceptionEnum.REGISTER_CODE_MISMATCH);
        }
        UserInfo userInfo = this.checkPhone(phone);
        userInfo.setUserPassword(password);
        int count = this.userInfomapper.updateByPrimaryKeySelective(userInfo);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //实名认证
    public void AuthenticationUser(UserInfo info, Integer id) {
        //设置用户实名认证状态为审核中
        info.setUserState(2);
        info.setUserId(id);
        int count = this.userInfomapper.updateByPrimaryKeySelective(info);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //绑定微信
    public void bindWeChat(Integer id, String userWeChatOpenid) {
        //用户主键不能为空
        if (id == null) {
            throw new CommonException(ExceptionEnum.USER_KET_MISMATCH);
        }
        //微信的OpenId不能为空
        if (userWeChatOpenid == null) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //查询此OpenId是否被绑定过
        int count1 = checkWeChatAndAliPay(0, userWeChatOpenid);
        //如果已存在抛异常
        if (count1 != 0) {
            throw new CommonException(ExceptionEnum.WE_CHAT_IS_ALREADY_EXISTED);
        }
        UserInfo userInfo = this.userInfomapper.selectByPrimaryKey(id);
        //用户不能为空
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.USER_IS_NOT_FOUND);
        }
        //把微信的OpenId插入到用户表
        userInfo.setUserWeChatOpenid(userWeChatOpenid);
        int count = this.userInfomapper.updateByPrimaryKeySelective(userInfo);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //绑定支付宝
    public void bindAliPay(Integer id, String userAliPayOpenid) {
        //用户Id不能为空 为空抛异常
        if (id == null) {
            throw new CommonException(ExceptionEnum.USER_KET_MISMATCH);
        }
        //支付宝OpenId不能为空 为空抛异常
        if (userAliPayOpenid == null) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //查询此OpenId是否被绑定过
        int count1 = checkWeChatAndAliPay(1, userAliPayOpenid);
        //如果已存在抛异常
        if (count1 != 0) {
            throw new CommonException(ExceptionEnum.ALI_PAY_IS_ALREADY_EXISTED);
        }
        //用户不能为空
        UserInfo userInfo = this.userInfomapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.USER_IS_NOT_FOUND);
        }
        //把支付宝OpenId插入用户表
        userInfo.setUserAliPayOpenid(userAliPayOpenid);
        int count = this.userInfomapper.updateByPrimaryKeySelective(userInfo);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //微信和支付宝登录
    public UserInfo loginByWeChatAndAliPay(String OpenId, int type) {
        //判断微信OpenId是否为空 为空抛异常
        if (StringUtils.isBlank(OpenId)) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //查询微信OpenId是否被绑定过
        int count = checkWeChatAndAliPay(type, OpenId);
        UserInfo userInfo = new UserInfo();
        //未绑定 返回空
        if (count == 0) {
            return userInfo;
        }
        //已绑定0.微信1. 支付宝
        if (0 == type) {
            userInfo.setUserWeChatOpenid(OpenId);
        } else {
            userInfo.setUserAliPayOpenid(OpenId);
        }
        //绑定过返回用户信息,登录
        return this.userInfomapper.selectOne(userInfo);
    }


    //绑定手机号并登录
    public UserInfo bandWeChatAndAliPay(String OpenId, String userPhoneNumber, String userPassword, String type, String registerCode) {
        //如果参数为空抛异常
        if (StringUtils.isBlank(OpenId) && StringUtils.isBlank(userPhoneNumber) &&
                StringUtils.isBlank(userPassword) && StringUtils.isBlank(type) && StringUtils.isBlank(registerCode)) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //验证注册码是否正确
        String code = (String) redisTemplate.opsForValue().get(PHONE_NUMBER + userPhoneNumber);
        if (!StringUtils.equals(code, registerCode)) {
            throw new CommonException(ExceptionEnum.REGISTER_CODE_MISMATCH);
        }
        //获取用户信息
        UserInfo userInfo1 = checkPhone(userPhoneNumber);
        //用户为空创建一个用户
        if (userInfo1 == null) {
            UserInfo userInfo = new UserInfo();
            //创建用户
            userInfo.setUserPhoneNumber(userPhoneNumber);
            userInfo.setUserPassword(userPassword);
            //0.微信1.支付宝
            if (StringUtils.equals("0", type)) {
                userInfo.setUserWeChatOpenid(OpenId);
            } else {
                userInfo.setUserAliPayOpenid(OpenId);
            }
            int count = this.userInfomapper.insertSelective(userInfo);
            if (count != 1) {
                throw new CommonException(ExceptionEnum.SAVE_FAILURE);
            }
            return userInfo;
        } else {
            UserInfo userInfo = new UserInfo();
            //创建用户
            userInfo.setUserPhoneNumber(userPhoneNumber);
            userInfo.setUserPassword(userPassword);
            //0.微信1.支付宝
            if (StringUtils.equals("0", type)) {
                userInfo.setUserWeChatOpenid(OpenId);
            } else {
                userInfo.setUserAliPayOpenid(OpenId);
            }
            int count = this.userInfomapper.updateByPrimaryKey(userInfo);
            if (count != 1) {
                throw new CommonException(ExceptionEnum.SAVE_FAILURE);
            }
            return userInfo;
        }
    }


    //根据手机号验证数据库是否由此用户
    private UserInfo checkPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("userPhoneNumber", phone);
        return this.userInfomapper.selectOneByExample(example);

    }

    //检查支付宝或微信账号是否存在0.微信1.支付宝
    private int checkWeChatAndAliPay(int type, String openId) {
        if (type == 0) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserWeChatOpenid(openId);
            return this.userInfomapper.selectCount(userInfo);
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserAliPayOpenid(openId);
            return this.userInfomapper.selectCount(userInfo);
        }
    }

    //更换密码
    public void changePassWord(Integer id, String oldPassWord, String newPassWord) {
        //非空验证
        if (StringUtils.isBlank(oldPassWord) && StringUtils.isBlank(newPassWord) && id == null) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //查询用户信息
        UserInfo userInfo = this.userInfomapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.USER_IS_NOT_FOUND);
        }
        //匹配用户的密码
        if (!StringUtils.equals(oldPassWord, userInfo.getUserPassword())) {
            throw new CommonException(ExceptionEnum.USER_PASSWORD_MISMATCH);
        }
        //更新用户的密码
        userInfo.setUserPassword(newPassWord);
        int count = this.userInfomapper.updateByPrimaryKeySelective(userInfo);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //更换手机号
    public void changeUserPhoneNumber(Integer id, String phoneNumber, String changeCode) {
        //非空验证
        if (StringUtils.isBlank(phoneNumber) && StringUtils.isBlank(changeCode) && id == null) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //验证验证码
        String code = (String) redisTemplate.opsForValue().get(PHONE_NUMBER + phoneNumber);
        if (!StringUtils.equals(code, changeCode)) {
            throw new CommonException(ExceptionEnum.REGISTER_CODE_MISMATCH);
        }
        //获取用户信息
        UserInfo userInfo = this.userInfomapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.USER_IS_NOT_FOUND);
        }
        userInfo.setUserPhoneNumber(phoneNumber);
        int count = this.userInfomapper.updateByPrimaryKeySelective(userInfo);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }
}
