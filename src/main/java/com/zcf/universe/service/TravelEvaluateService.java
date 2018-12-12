package com.zcf.universe.service;

import com.zcf.universe.pojo.TravelEvaluate;
import com.zcf.universe.mapper.TravelEvaluateMapper;
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
public class TravelEvaluateService {

    @Autowired
    private TravelEvaluateMapper travelEvaluatemapper;

    //新增
    public void addTravelEvaluate(TravelEvaluate travelEvaluate) {
        int count = this.travelEvaluatemapper.insertSelective(travelEvaluate);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }


    //查询单个
    public TravelEvaluate getTravelEvaluate(Integer id) {
        TravelEvaluate TravelEvaluate = this.travelEvaluatemapper.selectByPrimaryKey(id);
        if (TravelEvaluate == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return TravelEvaluate;
    }

    //搜索该景点的评论
    public List<TravelEvaluate> searchTravelEvaluate(Integer evaluateSceneryId) {
        Example example = new Example(TravelEvaluate.class);
        example.createCriteria().andEqualTo("evaluateSceneryId", evaluateSceneryId);//name为你想要搜索的字段
        List<TravelEvaluate> list = this.travelEvaluatemapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
