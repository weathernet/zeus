package com.zcf.universe.mapper;

import com.zcf.universe.common.mybatis.MyMapper;
import com.zcf.universe.pojo.User;


public interface UserMapper extends MyMapper<User> {
    User selectOneUser();

}
