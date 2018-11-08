package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.common.utils.IDUtils;
import com.zcf.universe.mapper.UserInfoMapper;
import com.zcf.universe.pojo.UserInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by YuanQJ on 2018/10/31.
 */
@Service
public class UserInfoService {
    //设置RedisKey的前缀
    public static final String PHONE_NUMBER = "PHONE_NUMBER:";
    @Autowired
    private UserInfoMapper userInfomapper;

    @Autowired
    private RedisTemplate redisTemplate;

    // 注册时的验证码
    public void getCode(String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
        if (this.checkPhone(phone)) {
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
        String random = IDUtils.Random();//获取随机数
        //SmsUtils.sendRegister(phone, random);//发送验证码
        //把验证码放入Redis中并设置3分钟的过期时间
        redisTemplate.opsForValue().set(PHONE_NUMBER + phone, random, 60 * 3, TimeUnit.SECONDS);
    }

    //用户注册
    public boolean registerUser(UserInfo userInfo, String registerCode) {
        //获取redis中
        String code = (String) redisTemplate.opsForValue().get(PHONE_NUMBER + userInfo.getUserPhoneNumber());
        if (!StringUtils.equals(code, registerCode)) {
            System.out.println("验证码错误");
            return false;
        }
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        return this.userInfomapper.insert(userInfo) == 1;
    }


    //更新用户信息
    public boolean updateUser(UserInfo user, Integer id) {
        user.setUserId(id);
        return this.userInfomapper.updateByPrimaryKeySelective(user) == 1;
    }

    // 根据主键获取用户的信息
    public UserInfo getUserInfo(Integer id) {
        return this.userInfomapper.selectByPrimaryKey(id);
    }

    //验证数据库是否由此手机号
    public boolean checkPhone(String phone) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("userPhoneNumber", phone);
        UserInfo userInfo = this.userInfomapper.selectOneByExample(example);
        return ObjectUtils.allNotNull(userInfo);
    }

    public UserInfo loginUser(String userPhoneNumber, String userPassword) {
        if (!this.checkPhone(userPhoneNumber)) {
            System.out.println("数据库中没有此数据");
            return null;
        }
        UserInfo userinfo = new UserInfo();
        userinfo.setUserPhoneNumber(userPhoneNumber);
        UserInfo userInfo = this.userInfomapper.selectOne(userinfo);
        boolean equals = StringUtils.equals(userInfo.getUserPassword(), userPassword);
        if (equals) {
            return userInfo;
        } else {
            return null;
        }
    }

    public void uploadUserHeadPortrait(Integer id, String userHeadPortrait) {
        UserInfo userInfo = this.userInfomapper.selectByPrimaryKey(id);
        userInfo.setUserHeadPortrait(userHeadPortrait);
    }
}
