package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.UserVipMapper;
import com.zcf.universe.pojo.UserVip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@Service
public class UserVipService {

    @Autowired
    private UserVipMapper userVipmapper;

    //新增
    public void addUserVip(UserVip userVip) {
        int count = this.userVipmapper.insert(userVip);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteUserVip(Integer id) {
        int count = this.userVipmapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateUserVip(UserVip userVip) {
        int count = this.userVipmapper.updateByPrimaryKeySelective(userVip);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<UserVip> getAllUserVip() {
        List<UserVip> list = this.userVipmapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public UserVip getUserVip(Integer id) {
        UserVip UserVip = this.userVipmapper.selectByPrimaryKey(id);
        if (UserVip == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return UserVip;
    }

    //字段搜索
    public List<UserVip> searchUserVip(String keywords) {
        Example example = new Example(UserVip.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<UserVip> list = this.userVipmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
