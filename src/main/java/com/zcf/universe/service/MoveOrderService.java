package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.MoveOrderMapper;
import com.zcf.universe.pojo.MoveOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/15.
 */
@Service
public class MoveOrderService {

    @Autowired
    private MoveOrderMapper moveOrdermapper;

    //新增
    public void addMoveOrder(MoveOrder moveOrder) {
        int count = this.moveOrdermapper.insertSelective(moveOrder);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }
    }

    //查询单个
    public MoveOrder getMoveOrder(Integer id) {
        MoveOrder MoveOrder = this.moveOrdermapper.selectByPrimaryKey(id);
        if (MoveOrder == null) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return MoveOrder;
    }

    public List<MoveOrder> getMoveOrderByUser(Integer userId) {
        Example example = new Example(MoveOrder.class);
        example.createCriteria().andEqualTo("orderUserId", userId);
        final List<MoveOrder> moveOrders = this.moveOrdermapper.selectByExample(example);
        if (moveOrders.size() == 0) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return moveOrders;
    }
}
