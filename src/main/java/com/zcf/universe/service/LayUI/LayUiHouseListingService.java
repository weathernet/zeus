package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HouseListingMapper;
import com.zcf.universe.pojo.HouseListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/06.
 */
@Service
public class LayUiHouseListingService {

    @Autowired
    private HouseListingMapper LayUihouseListingmapper;

    public boolean add(HouseListing houseListing) {
        return this.LayUihouseListingmapper.insert(houseListing) == 1;
    }

    public boolean delete(Integer id) {
        return this.LayUihouseListingmapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(HouseListing houseListing) {
        return this.LayUihouseListingmapper.updateByPrimaryKeySelective(houseListing) == 1;
    }

    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HouseListing> list = this.LayUihouseListingmapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(HouseListing.class);
        keywords = "%" + keywords + "%";
        example.createCriteria().andLike("name", keywords);//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<HouseListing> list = this.LayUihouseListingmapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
