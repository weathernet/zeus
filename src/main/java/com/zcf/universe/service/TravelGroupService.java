package com.zcf.universe.service;

import com.zcf.universe.pojo.TravelGroup;
import com.zcf.universe.mapper.TravelGroupMapper;
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
public class TravelGroupService {

    @Autowired
    private TravelGroupMapper travelGroupmapper;

    //查询所有
    public List<TravelGroup> getAllTravelGroup() {
        List<TravelGroup> list = this.travelGroupmapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

}
