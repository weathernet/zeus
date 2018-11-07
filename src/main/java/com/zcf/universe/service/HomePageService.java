package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HomeGroupsMapper;
import com.zcf.universe.pojo.HomeGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yuan
 * @date 2018/11/7 0007
 */
@Service
public class HomePageService {
    @Autowired
    //首页分类
    private HomeGroupsMapper homeGroupsMapper;

    //获取所有的首页分类
    public List<HomeGroups> getHomeGroups() {
        List<HomeGroups> list = this.homeGroupsMapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOME_PAGE_GROUPS_BE_NULL);
        }
        return list;
    }
}
