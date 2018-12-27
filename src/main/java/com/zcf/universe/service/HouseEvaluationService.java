package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HouseEvaluationMapper;
import com.zcf.universe.pojo.HouseEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/26
 */
@Service
public class HouseEvaluationService {

    @Autowired
    private HouseEvaluationMapper houseEvaluationmapper;

    //查询所有
    public List<HouseEvaluation> getAllHouseEvaluationByUser(Integer userId) {
        Example example = new Example(HouseEvaluation.class);
        example.createCriteria().andEqualTo("userId", userId);
        List<HouseEvaluation> list = this.houseEvaluationmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }


}
