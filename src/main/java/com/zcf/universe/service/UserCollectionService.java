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

    //查询所有用戶收藏
    public List<UserCollection> getAllUserCollection(Integer id) {
        Example example =new Example(UserCollection.class);
        example.createCriteria().andEqualTo("collectionUserId",id);
        List<UserCollection> list = this.userCollectionmapper.selectByExample(example);
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

}
