package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HomeBannerMapper;
import com.zcf.universe.mapper.HomeGroupsMapper;
import com.zcf.universe.mapper.HomeStoryMapper;
import com.zcf.universe.pojo.HomeBanner;
import com.zcf.universe.pojo.HomeGroups;
import com.zcf.universe.pojo.HomeStory;
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
    //首页轮播
    @Autowired
    private HomeBannerMapper homeBannerMapper;
    //首页故事
    private HomeStoryMapper homeStoryMapper;

    //获取所有的首页分类
    public List<HomeGroups> getHomeGroups() {
        List<HomeGroups> list = this.homeGroupsMapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOME_PAGE_GROUPS_BE_NULL);
        }
        return list;
    }

    //获取所有的轮播图
    public List<HomeBanner> getHomeBanner() {
        List<HomeBanner> list = this.homeBannerMapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOME_PAGE_GROUPS_BE_NULL);
        }
        return list;
    }

    //获取所有的故事
    public List<HomeStory> getHomeStories() {
        List<HomeStory> list = homeStoryMapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOME_PAGE_GROUPS_BE_NULL);
        }
        return list;
    }

    //获取当前的故事
    public HomeStory getHomeStory(Integer id) {
        HomeStory homeStory = this.homeStoryMapper.selectByPrimaryKey(id);
        if (homeStory == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return homeStory;
    }
}
