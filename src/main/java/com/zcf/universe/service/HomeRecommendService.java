package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HomeRecommendMapper;
import com.zcf.universe.pojo.HomeRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@Service
public class HomeRecommendService {

    @Autowired
    private HomeRecommendMapper homeRecommendmapper;



    //根据状态查询推荐
    public List<HomeRecommend> getHomeRecommendType(Integer type) {
        Example example = new Example(HomeRecommend.class);
        example.createCriteria().andEqualTo("recommendType", type);
        List<HomeRecommend> list = this.homeRecommendmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public HomeRecommend getHomeRecommend(Integer id) {
        HomeRecommend HomeRecommend = this.homeRecommendmapper.selectByPrimaryKey(id);
        if (HomeRecommend == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return HomeRecommend;
    }

}
