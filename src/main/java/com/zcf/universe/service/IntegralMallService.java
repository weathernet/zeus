package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.IntegralMallMapper;
import com.zcf.universe.pojo.IntegralMall;
import com.zcf.universe.pojo.MallOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/18
 */
@Service
public class IntegralMallService {

    @Autowired
    private IntegralMallMapper integralMallmapper;

    //查询所有
    public List<IntegralMall> getAllIntegralMall() {
        List<IntegralMall> list = this.integralMallmapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }

    //查询单个
    public IntegralMall getIntegralMall(Integer id) {
        IntegralMall IntegralMall = this.integralMallmapper.selectByPrimaryKey(id);
        if (IntegralMall == null) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return IntegralMall;
    }


}
