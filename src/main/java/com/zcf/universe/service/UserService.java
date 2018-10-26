package com.zcf.universe.service;

import com.zcf.universe.common.json.Body;
import com.zcf.universe.entity.User;
import com.zcf.universe.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public Body login(String username, String password) {
        User user = new User();
        if (user == null) {
            return Body.newInstance(542, "用户不存在");
        }
        logger.info("= = = 》 {}用户登录成功", user.getUserName());
        return Body.newInstance(user);
    }

    public List<User> findList() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    public boolean addUser(User user) {
        return this.userMapper.insert(user) == 1;
    }

    public boolean updateUser(User user) {
        return this.userMapper.updateByPrimaryKey(user) == 1;
    }

    public boolean deleteUser(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id) == 1;
    }
}
