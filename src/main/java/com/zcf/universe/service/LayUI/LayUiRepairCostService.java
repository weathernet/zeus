package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.RepairCostMapper;
import com.zcf.universe.pojo.RepairCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/13.
 */
@Service
public class LayUiRepairCostService{

    @Autowired
    private RepairCostMapper LayUiRepairCostMapper;

    //新增
    public boolean add(RepairCost repairCost) {
        return this.LayUiRepairCostMapper.insert(repairCost) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiRepairCostMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(RepairCost repairCost) {
        return this.LayUiRepairCostMapper.updateByPrimaryKeySelective(repairCost) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<RepairCost> list = this.LayUiRepairCostMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
    //查询该子标题下所有的费用标准

    public LayUiResult queryById(Integer page, Integer limit,Integer id){
        PageHelper.startPage(page, limit);
        Example example =new Example(RepairCost.class);
        example.createCriteria().andEqualTo("costSubMenuId",id);
        List<RepairCost> list = this.LayUiRepairCostMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(RepairCost.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<RepairCost> list = this.LayUiRepairCostMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
