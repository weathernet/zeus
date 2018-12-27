package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.OwnerPhoneMapper;
import com.zcf.universe.pojo.OwnerPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@Service
public class OwnerPhoneService {

    @Autowired
    private OwnerPhoneMapper ownerPhonemapper;

    //查询单个
    public OwnerPhone getOwnerPhone(Integer id) {
        OwnerPhone OwnerPhone = this.ownerPhonemapper.selectByPrimaryKey(id);
        if (OwnerPhone == null) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return OwnerPhone;
    }
}
