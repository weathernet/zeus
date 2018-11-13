package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.RepairDetailsMapper;
import com.zcf.universe.pojo.RepairDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/13.
 */
@Service
public class RepairDetailsService {

    @Autowired
    private RepairDetailsMapper repairDetailsmapper;

    //新增
    public void addRepairDetails(RepairDetails repairDetails) {
        boolean flag = this.repairDetailsmapper.insert(repairDetails) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteRepairDetails(Integer id) {
        boolean flag = this.repairDetailsmapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateRepairDetails(RepairDetails repairDetails) {
        boolean flag =this.repairDetailsmapper.updateByPrimaryKeySelective(repairDetails) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<RepairDetails> getAllRepairDetails() {
        List<RepairDetails> list = this.repairDetailsmapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public RepairDetails getRepairDetails(Integer id){
        RepairDetails RepairDetails = this.repairDetailsmapper.selectByPrimaryKey(id);
        if (RepairDetails == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return RepairDetails;
    }

    //字段搜索
     public List<RepairDetails> searchRepairDetails(String keywords) {
        Example example = new Example(RepairDetails.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<RepairDetails> list = this.repairDetailsmapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
