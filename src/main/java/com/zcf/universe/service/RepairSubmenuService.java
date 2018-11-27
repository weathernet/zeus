package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.RepairSubmenuMapper;
import com.zcf.universe.pojo.RepairSubmenu;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/12.
 */
@Service
public class RepairSubmenuService{

    @Autowired
    private RepairSubmenuMapper repairSubmenumapper;

    //查询所有
    public List<RepairSubmenu> getAllRepairSubmenu() {
        List<RepairSubmenu> list = this.repairSubmenumapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
    //根据父Id查询
    public List<RepairSubmenu> getRepairSubmenuByMenuId(Integer id){
        Example example =new Example(RepairSubmenu.class);
        example.createCriteria().andEqualTo("repairMenuId",id);
        List<RepairSubmenu> list = this.repairSubmenumapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public RepairSubmenu getRepairSubmenu(Integer id){
        RepairSubmenu RepairSubmenu = this.repairSubmenumapper.selectByPrimaryKey(id);
        if (RepairSubmenu == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return RepairSubmenu;
    }

    //字段搜索
     public List<RepairSubmenu> searchRepairSubmenu(String keywords) {
        Example example = new Example(RepairSubmenu.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<RepairSubmenu> list = this.repairSubmenumapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
