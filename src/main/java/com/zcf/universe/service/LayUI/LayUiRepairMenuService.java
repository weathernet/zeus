package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.RepairMenuMapper;
import com.zcf.universe.pojo.RepairMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/12.
 */
@Service
public class LayUiRepairMenuService{

    @Autowired
    private RepairMenuMapper LayUiRepairMenuMapper;

    //新增
    public boolean add(RepairMenu repairMenu) {
        return this.LayUiRepairMenuMapper.insert(repairMenu) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiRepairMenuMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(RepairMenu repairMenu) {
        return this.LayUiRepairMenuMapper.updateByPrimaryKeySelective(repairMenu) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<RepairMenu> list = this.LayUiRepairMenuMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(RepairMenu.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<RepairMenu> list = this.LayUiRepairMenuMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
