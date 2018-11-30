package com.zcf.universe.service;

import com.zcf.universe.pojo.HousingButler;
import com.zcf.universe.mapper.HousingButlerMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/28.
 */
@Service
public class HousingButlerService{

    @Autowired
    private HousingButlerMapper housingButlermapper;


    //查询单个
    public HousingButler getHousingButler(Integer id){
        HousingButler HousingButler = this.housingButlermapper.selectByPrimaryKey(id);
        if (HousingButler == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return HousingButler;
    }

}
