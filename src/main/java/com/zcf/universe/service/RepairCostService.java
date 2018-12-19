package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.RepairCostMapper;
import com.zcf.universe.pojo.RepairCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/13.
 */
@Service
public class RepairCostService{

    @Autowired
    private RepairCostMapper repairCostmapper;


    //查询所有
    public List<RepairCost> getAllRepairCost() {
        List<RepairCost> list = this.repairCostmapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public RepairCost getRepairCost(Integer id){
        RepairCost RepairCost = this.repairCostmapper.selectByPrimaryKey(id);
        if (RepairCost == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return RepairCost;
    }

}
