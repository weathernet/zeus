package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.TravelGroup;
import com.zcf.universe.mapper.TravelGroupMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/19.
 */
@Service
public class LayUiTravelGroupService{

    @Autowired
    private TravelGroupMapper LayUiTravelGroupMapper;

    //新增
    public boolean add(TravelGroup travelGroup) {
        return this.LayUiTravelGroupMapper.insert(travelGroup) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiTravelGroupMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(TravelGroup travelGroup) {
        return this.LayUiTravelGroupMapper.updateByPrimaryKeySelective(travelGroup) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TravelGroup> list = this.LayUiTravelGroupMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(TravelGroup.class);
        example.createCriteria().andLike("groupId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<TravelGroup> list = this.LayUiTravelGroupMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
