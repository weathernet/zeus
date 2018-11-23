package com.zcf.universe.service;

import com.zcf.universe.pojo.TravelScenery;
import com.zcf.universe.mapper.TravelSceneryMapper;
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
public class TravelSceneryService {

    @Autowired
    private TravelSceneryMapper travelScenerymapper;

    //新增
    public void addTravelScenery(TravelScenery travelScenery) {
        int count = this.travelScenerymapper.insertSelective(travelScenery);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteTravelScenery(Integer id) {
        int count = this.travelScenerymapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateTravelScenery(TravelScenery travelScenery) {
        int count = this.travelScenerymapper.updateByPrimaryKeySelective(travelScenery);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<TravelScenery> getAllTravelScenery() {
        List<TravelScenery> list = this.travelScenerymapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public TravelScenery getTravelScenery(Integer id) {
        TravelScenery TravelScenery = this.travelScenerymapper.selectByPrimaryKey(id);
        if (TravelScenery == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return TravelScenery;
    }

    //字段搜索
    public List<TravelScenery> searchTravelScenery(String keywords) {
        Example example = new Example(TravelScenery.class);
        example.createCriteria().orLike("sceneryTitle","%" + keywords + "%")
                .orLike("sceneryAddress", "%" + keywords + "%");//name为你想要搜索的字段
        List<TravelScenery> list = this.travelScenerymapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
        return list;
    }

    //字段搜索
    public List<TravelScenery> searchTravelSceneryByGroup(String groupid) {
        Example example = new Example(TravelScenery.class);
        example.createCriteria().andEqualTo("sceneryGroup",groupid);
        List<TravelScenery> list = this.travelScenerymapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
        return list;
    }
}
