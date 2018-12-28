package com.zcf.universe.service;

import com.zcf.universe.pojo.ServiceCleanup;
import com.zcf.universe.mapper.ServiceCleanupMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/26.
 */
@Service
public class ServiceCleanupService {

    @Autowired
    private ServiceCleanupMapper serviceCleanupmapper;

    //查询所有
    public List<ServiceCleanup> getAllServiceCleanup() {
        Example example = new Example(ServiceCleanup.class);
        example.selectProperties("cleanupId","title", "icon");
        List<ServiceCleanup> list = this.serviceCleanupmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public ServiceCleanup getServiceCleanup(Integer id) {
        ServiceCleanup ServiceCleanup = this.serviceCleanupmapper.selectByPrimaryKey(id);
        if (ServiceCleanup == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return ServiceCleanup;
    }

}
