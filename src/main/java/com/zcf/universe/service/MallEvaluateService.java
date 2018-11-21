package com.zcf.universe.service;

import com.zcf.universe.pojo.MallEvaluate;
import com.zcf.universe.mapper.MallEvaluateMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;

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
        int count = this.mallEvaluatemapper.insert(mallEvaluate);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMallEvaluate(Integer id) {
        int count = this.mallEvaluatemapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMallEvaluate(MallEvaluate mallEvaluate) {
        int count = this.mallEvaluatemapper.updateByPrimaryKeySelective(mallEvaluate);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<MallEvaluate> getAllMallEvaluate() {
        List<MallEvaluate> list = this.mallEvaluatemapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public MallEvaluate getMallEvaluate(Integer id) {
        MallEvaluate MallEvaluate = this.mallEvaluatemapper.selectByPrimaryKey(id);
        if (MallEvaluate == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MallEvaluate;
    }


}
