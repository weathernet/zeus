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

    //新增
    public void addRepairCost(RepairCost repairCost) {
        boolean flag = this.repairCostmapper.insert(repairCost) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteRepairCost(Integer id) {
        boolean flag = this.repairCostmapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateRepairCost(RepairCost repairCost) {
        boolean flag =this.repairCostmapper.updateByPrimaryKeySelective(repairCost) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

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

    //字段搜索
     public List<RepairCost> searchRepairCost(String keywords) {
        Example example = new Example(RepairCost.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<RepairCost> list = this.repairCostmapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
