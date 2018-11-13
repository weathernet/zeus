package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.RepairOrderMapper;
import com.zcf.universe.pojo.RepairOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/13.
 */
@Service
public class LayUiRepairOrderService{

    @Autowired
    private RepairOrderMapper LayUiRepairOrderMapper;

    //新增
    public boolean add(RepairOrder repairOrder) {
        return this.LayUiRepairOrderMapper.insert(repairOrder) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiRepairOrderMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(RepairOrder repairOrder) {
        return this.LayUiRepairOrderMapper.updateByPrimaryKeySelective(repairOrder) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<RepairOrder> list = this.LayUiRepairOrderMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(RepairOrder.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<RepairOrder> list = this.LayUiRepairOrderMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
