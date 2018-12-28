package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HomeTravelMapper;
import com.zcf.universe.pojo.HomeTravel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 袁齐吉
* @date 2018/12/28
*/
@Service
public class HomeTravelService {

    @Autowired
    private HomeTravelMapper homeTravelmapper;

    //查询单个
    public HomeTravel getHomeTravel(Integer id){
        HomeTravel HomeTravel = this.homeTravelmapper.selectByPrimaryKey(id);
        if (HomeTravel == null) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return HomeTravel;
    }

}
