package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.RepairOrderMapper;
import com.zcf.universe.pojo.RepairOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/13.
 */
@Service
public class RepairOrderService{

    @Autowired
    private RepairOrderMapper repairOrdermapper;

    //新增
    public void addRepairOrder(RepairOrder repairOrder) {
        int count = this.repairOrdermapper.insert(repairOrder) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteRepairOrder(Integer id) {
        int count = this.repairOrdermapper.deleteByPrimaryKey(id) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateRepairOrder(RepairOrder repairOrder) {
        int count =this.repairOrdermapper.updateByPrimaryKeySelective(repairOrder) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<RepairOrder> getAllRepairOrder() {
        List<RepairOrder> list = this.repairOrdermapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public RepairOrder getRepairOrder(Integer id){
        RepairOrder RepairOrder = this.repairOrdermapper.selectByPrimaryKey(id);
        if (RepairOrder == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return RepairOrder;
    }

    //字段搜索
     public List<RepairOrder> searchRepairOrder(String keywords) {
        Example example = new Example(RepairOrder.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<RepairOrder> list = this.repairOrdermapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
