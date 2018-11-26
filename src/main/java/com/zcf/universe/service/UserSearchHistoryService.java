package com.zcf.universe.service;

import com.zcf.universe.pojo.UserSearchHistory;
import com.zcf.universe.mapper.UserSearchHistoryMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/19.
 */
@Service
public class UserSearchHistoryService {

    @Autowired
    private UserSearchHistoryMapper userSearchHistorymapper;

    //新增
    public void addUserSearchHistory(UserSearchHistory userSearchHistory) {
        int count = this.userSearchHistorymapper.insertSelective(userSearchHistory);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteUserSearchHistory(Integer id) {
        int count = this.userSearchHistorymapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }


    //查询当前用户的搜索历史
    public List<UserSearchHistory> getUserSearchHistory(Integer id) {
        Example example =new Example(UserSearchHistory.class);
        example.createCriteria().andEqualTo("historyUserId",id);

        List<UserSearchHistory> list = this.userSearchHistorymapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

}
