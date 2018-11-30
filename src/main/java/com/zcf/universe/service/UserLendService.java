package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.UserLendMapper;
import com.zcf.universe.pojo.UserLend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@Service
public class UserLendService {

    @Autowired
    private UserLendMapper userLendmapper;

    //新增
    public void addUserLend(UserLend userLend) {
        int count = this.userLendmapper.insertSelective(userLend) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }


    //查询当前用户的信息
    public List<UserLend> getAllUserLend(Integer id) {
        Example example =new Example(UserLend.class);
        example.createCriteria().andEqualTo("lendUserId",id);
        List<UserLend> list = this.userLendmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public UserLend getUserLend(Integer id) {
        UserLend UserLend = this.userLendmapper.selectByPrimaryKey(id);
        if (UserLend == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return UserLend;
    }

}
