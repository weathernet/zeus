package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HomeGroupsMapper;
import com.zcf.universe.pojo.HomeGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * Created by YuanQJ on 2018/11/07.
 */
@Service
public class LayUiHomeGroupsService{

    @Autowired
    private HomeGroupsMapper LayUihomeGroupsmapper;

    public boolean add(HomeGroups homeGroups) {
        return this.LayUihomeGroupsmapper.insert(homeGroups) == 1;
    }

    public boolean delete(Integer id) {
        return this.LayUihomeGroupsmapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(HomeGroups homeGroups) {
        return this.LayUihomeGroupsmapper.updateByPrimaryKeySelective(homeGroups) == 1;
    }

    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HomeGroups> list = this.LayUihomeGroupsmapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(HomeGroups.class);
        keywords = "%" + keywords + "%";
        example.createCriteria().andLike("name", keywords);//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<HomeGroups> list = this.LayUihomeGroupsmapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
