package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.HousingButler;
import com.zcf.universe.mapper.HousingButlerMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/28.
 */
@Service
public class LayUiHousingButlerService{

    @Autowired
    private HousingButlerMapper LayUiHousingButlerMapper;

    //新增
    public boolean add(HousingButler housingButler) {
        return this.LayUiHousingButlerMapper.insert(housingButler) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiHousingButlerMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(HousingButler housingButler) {
        return this.LayUiHousingButlerMapper.updateByPrimaryKeySelective(housingButler) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HousingButler> list = this.LayUiHousingButlerMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(HousingButler.class);
        example.createCriteria().andLike("butlerId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<HousingButler> list = this.LayUiHousingButlerMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
