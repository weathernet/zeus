package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.IDUtils;
import com.zcf.universe.mapper.UserInfoMapper;
import com.zcf.universe.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
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
    public static final List<String> ALLOW_TYPES = Arrays.asList("image/jpeg", "image/png", "image/jpg");

    //设置RedisKey的前缀
    public static final String PHONE_NUMBER = "PHONE_NUMBER:";

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
        //SmsUtils.sendRegister(phone, random);//发送验证码
        //把验证码放入Redis中并设置3分钟的过期时间
        redisTemplate.opsForValue().set(PHONE_NUMBER + phone, random, 60 * 3, TimeUnit.SECONDS);
    }

    // 忘记密码时的验证码
    public void getForgetCode(String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
        this.checkPhone(phone);
        String random = IDUtils.Random();//获取随机数
        //SmsUtils.sendRegister(phone, random);//发送验证码
        //把验证码放入Redis中并设置3分钟的过期时间
        redisTemplate.opsForValue().set(PHONE_NUMBER + phone, random, 60 * 3, TimeUnit.SECONDS);
    }

    //用户注册
    public void registerUser(UserInfo userInfo, String registerCode) {
        //获取手机号的验证码
        String code = (String) redisTemplate.opsForValue().get(PHONE_NUMBER + userInfo.getUserPhoneNumber());
        if (!StringUtils.equals(code, registerCode)) {
            throw new CommonException(ExceptionEnum.REGISTER_CODE_MISMATCH);
        }
        userInfo.setUserNikeName("品家用户" + new Date());
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        int insert = this.userInfomapper.insert(userInfo);
        if (insert != 1) {
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
        this.checkPhone(userPhoneNumber);
        UserInfo userinfo = new UserInfo();
        userinfo.setUserPhoneNumber(userPhoneNumber);
        UserInfo userInfo = this.userInfomapper.selectOne(userinfo);
        boolean equals = StringUtils.equals(userInfo.getUserPassword(), userPassword);
        if (!equals) {
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
    public String uploadImage(MultipartFile file) {
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
            String userHeadPortrait = FileUploadUtils.fileUpload(file, path, customPath);
            return userHeadPortrait;
        } catch (IOException e) {
            log.error("上传文件失败", e);
        }
        return null;
    }

    //查看该用户是否已经实名认证
    public boolean isAuthentication(Integer id) {
        UserInfo userInfo = this.getUserInfo(id);
        int userState = userInfo.getUserState();
        if (1 == userState) {
            return true;//已经实名
        } else {
            return false;//未实名
        }
    }

    // 根据主键获取用户的信息
    public UserInfo getUserInfo(Integer id) {
        UserInfo userInfo = this.userInfomapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.USER_IS_NOT_FOUND);
        }
        return userInfo;
    }

    //验证数据库是否由此用户
    public UserInfo checkPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("userPhoneNumber", phone);
        UserInfo userInfo = this.userInfomapper.selectOneByExample(example);
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_IS_NOT_FOUND);
        }
        return userInfo;
    }

    //修改用户密码
    public void updateUSerPasswords(String phone, String password) {
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

    //支付宝登陆
    public void loginByAliPay(String userAliPayOpenid) {
        //判断支付宝OpenId是否为空 为空抛异常
        if (StringUtils.isBlank(userAliPayOpenid)) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }

        UserInfo user = new UserInfo();
        user.setUserAliPayOpenid(userAliPayOpenid);
        UserInfo userInfo = this.userInfomapper.selectOne(user);
        if (userInfo == null) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
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

}
