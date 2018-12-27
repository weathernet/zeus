package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HouseOrderMapper;
import com.zcf.universe.pojo.HouseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/27
 */
@Service
public class HouseOrderService {

    @Autowired
    private HouseOrderMapper houseOrdermapper;

    //新增
    public void addHouseOrder(HouseOrder houseOrder) {
        int count = this.houseOrdermapper.insertSelective(houseOrder);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }
    }


    //查询用户租房的订单
    public List<HouseOrder> getAllHouseOrder(Integer userId) {
        Example example = new Example(HouseOrder.class);
        example.createCriteria().andEqualTo("userId", userId);//name为你想要搜索的字段
        List<HouseOrder> list = this.houseOrdermapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }
}
