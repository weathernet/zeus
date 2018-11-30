package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HouseReserveMapper;
import com.zcf.universe.pojo.HouseReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/09.
 */
@Service
public class HouseReserveService {

    @Autowired
    private HouseReserveMapper houseReservemapper;

    //新增约看内容
    public void addHouseReserve(HouseReserve houseReserve) {
        int count = this.houseReservemapper.insertSelective(houseReserve);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }
    //取消约看
    public void cancelHouseReserve(Integer id) {
        HouseReserve houseReserve = this.houseReservemapper.selectByPrimaryKey(id);
        houseReserve.setReserveStatus("2");
        int count = this.houseReservemapper.updateByPrimaryKeySelective(houseReserve);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //删除约看内容
    public void deleteHouseReserve(Integer id) {
        int count = this.houseReservemapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }


    //查询当前用户的未完成预约
    public List<HouseReserve> getHouseReserve(Integer id) {
        Example example = new Example(HouseReserve.class);
        example.createCriteria().andEqualTo("reserveUserId", id).andEqualTo("reserveStatus", 0);
        final List<HouseReserve> list = this.houseReservemapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }

    //查询当前用户的非未完成预约
    public List<HouseReserve> houseReserveStatus(Integer id) {
        Example example = new Example(HouseReserve.class);
        example.createCriteria().andNotEqualTo("reserveStatus", 0).andEqualTo("reserveUserId", id);
        final List<HouseReserve> list = this.houseReservemapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }


}
