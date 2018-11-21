package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.UserCollectionMapper;
import com.zcf.universe.pojo.UserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@Service
public class UserCollectionService {

    @Autowired
    private UserCollectionMapper userCollectionmapper;

    //新增
    public void addUserCollection(UserCollection userCollection) {
        int count = this.userCollectionmapper.insertSelective(userCollection);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteUserCollection(Integer id) {
        int count = this.userCollectionmapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateUserCollection(UserCollection userCollection) {
        int count = this.userCollectionmapper.updateByPrimaryKeySelective(userCollection);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<UserCollection> getAllUserCollection() {
        List<UserCollection> list = this.userCollectionmapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public UserCollection getUserCollection(Integer id) {
        UserCollection UserCollection = this.userCollectionmapper.selectByPrimaryKey(id);
        if (UserCollection == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return UserCollection;
    }

    //字段搜索
    public List<UserCollection> searchUserCollection(String keywords) {
        Example example = new Example(UserCollection.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<UserCollection> list = this.userCollectionmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
