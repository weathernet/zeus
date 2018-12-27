package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.OwnerAdvantageMapper;
import com.zcf.universe.pojo.OwnerAdvantage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@Service
public class OwnerAdvantageService {

    @Autowired
    private OwnerAdvantageMapper ownerAdvantagemapper;

    //查询所有
    public List<OwnerAdvantage> getAllOwnerAdvantage() {
        List<OwnerAdvantage> list = this.ownerAdvantagemapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }

}
