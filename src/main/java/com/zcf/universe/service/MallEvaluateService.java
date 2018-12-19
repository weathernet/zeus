package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.MallEvaluateMapper;
import com.zcf.universe.pojo.MallEvaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/18.
 */
@Service
public class MallEvaluateService {

    @Autowired
    private MallEvaluateMapper mallEvaluatemapper;

    //新增
    public void addMallEvaluate(MallEvaluate mallEvaluate) {
        int count = this.mallEvaluatemapper.insertSelective(mallEvaluate);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }


    public List<MallEvaluate> getAllMallEvaluateByShop(Integer shopId) {
        Example example = new Example(MallEvaluate.class);
        example.createCriteria().andEqualTo("evaluateTraderId", shopId);
        return this.mallEvaluatemapper.selectByExample(example);
    }

    public List<MallEvaluate> getAllMallEvaluateByUser(Integer userId) {
        Example example = new Example(MallEvaluate.class);
        example.createCriteria().andEqualTo("evaluateUserId", userId);
        return this.mallEvaluatemapper.selectByExample(example);
    }
}
