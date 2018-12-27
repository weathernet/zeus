package com.zcf.universe.service;

import com.zcf.universe.pojo.MallBanner;
import com.zcf.universe.mapper.MallBannerMapper;
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
public class MallBannerService {

    @Autowired
    private MallBannerMapper mallBannermapper;

    public List<MallBanner> getAllMallBanner() {
        List<MallBanner> list = this.mallBannermapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

}
