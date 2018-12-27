package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.OwnerQuotationMapper;
import com.zcf.universe.pojo.OwnerQuotation;
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
public class OwnerQuotationService {

    @Autowired
    private OwnerQuotationMapper ownerQuotationmapper;

    //根据城市查询和户室查询
    public List<OwnerQuotation> searchOwnerQuotation(String city, String type) {
        Example example = new Example(OwnerQuotation.class);
        example.createCriteria().andEqualTo("city", city).andEqualTo("type", type);//name为你想要搜索的字段
        List<OwnerQuotation> list = this.ownerQuotationmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }
}
