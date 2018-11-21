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
        int count = this.userLendmapper.insert(userLend) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteUserLend(Integer id) {
        int count = this.userLendmapper.deleteByPrimaryKey(id) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateUserLend(UserLend userLend) {
        int count = this.userLendmapper.updateByPrimaryKeySelective(userLend) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<UserLend> getAllUserLend() {
        List<UserLend> list = this.userLendmapper.selectAll();
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

    //字段搜索
    public List<UserLend> searchUserLend(String keywords) {
        Example example = new Example(UserLend.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<UserLend> list = this.userLendmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
