package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.RepairMenuMapper;
import com.zcf.universe.pojo.RepairMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/12.
 */
@Service
public class RepairMenuService{

    @Autowired
    private RepairMenuMapper repairMenumapper;

    //新增
    public void addRepairMenu(RepairMenu repairMenu) {
        int count = this.repairMenumapper.insertSelective(repairMenu) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteRepairMenu(Integer id) {
        int count = this.repairMenumapper.deleteByPrimaryKey(id) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateRepairMenu(RepairMenu repairMenu) {
        int count =this.repairMenumapper.updateByPrimaryKeySelective(repairMenu) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<RepairMenu> getAllRepairMenu() {
        List<RepairMenu> list = this.repairMenumapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public RepairMenu getRepairMenu(Integer id){
        RepairMenu RepairMenu = this.repairMenumapper.selectByPrimaryKey(id);
        if (RepairMenu == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return RepairMenu;
    }

    //字段搜索
     public List<RepairMenu> searchRepairMenu(String keywords) {
        Example example = new Example(RepairMenu.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<RepairMenu> list = this.repairMenumapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
