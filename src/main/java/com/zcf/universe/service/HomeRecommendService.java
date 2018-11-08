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

    //新增
    public void addHomeRecommend(HomeRecommend homeRecommend) {
        boolean flag = this.homeRecommendmapper.insert(homeRecommend) == 1;
        if (flag) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteHomeRecommend(Integer id) {
        boolean flag = this.homeRecommendmapper.deleteByPrimaryKey(id) == 1;
        if (flag) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateHomeRecommend(HomeRecommend homeRecommend) {
        boolean flag = this.homeRecommendmapper.updateByPrimaryKeySelective(homeRecommend) == 1;
        if (flag) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<HomeRecommend> getAllHomeRecommend() {
        List<HomeRecommend> list = this.homeRecommendmapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

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

    //字段搜索
    public List<HomeRecommend> searchHomeRecommend(String keywords) {
        Example example = new Example(HomeRecommend.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<HomeRecommend> list = this.homeRecommendmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }


}
