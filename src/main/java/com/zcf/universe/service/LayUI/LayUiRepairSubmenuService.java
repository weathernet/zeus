package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.RepairSubmenuMapper;
import com.zcf.universe.pojo.RepairSubmenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/12.
 */
@Service
public class LayUiRepairSubmenuService{

    @Autowired
    private RepairSubmenuMapper LayUiRepairSubmenuMapper;

    //新增
    public boolean add(RepairSubmenu repairSubmenu) {
        return this.LayUiRepairSubmenuMapper.insert(repairSubmenu) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiRepairSubmenuMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(RepairSubmenu repairSubmenu) {
         return this.LayUiRepairSubmenuMapper.updateByPrimaryKeySelective(repairSubmenu) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<RepairSubmenu> list = this.LayUiRepairSubmenuMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(RepairSubmenu.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<RepairSubmenu> list = this.LayUiRepairSubmenuMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
