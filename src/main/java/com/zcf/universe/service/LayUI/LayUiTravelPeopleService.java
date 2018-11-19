package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.TravelPeople;
import com.zcf.universe.mapper.TravelPeopleMapper;
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
public class LayUiTravelPeopleService{

    @Autowired
    private TravelPeopleMapper LayUiTravelPeopleMapper;

    //新增
    public boolean add(TravelPeople travelPeople) {
        return this.LayUiTravelPeopleMapper.insert(travelPeople) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiTravelPeopleMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(TravelPeople travelPeople) {
        return this.LayUiTravelPeopleMapper.updateByPrimaryKeySelective(travelPeople) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TravelPeople> list = this.LayUiTravelPeopleMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(TravelPeople.class);
        example.createCriteria().andLike("peopleId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<TravelPeople> list = this.LayUiTravelPeopleMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
