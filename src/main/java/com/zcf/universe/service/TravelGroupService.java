package com.zcf.universe.service;

import com.zcf.universe.pojo.TravelGroup;
import com.zcf.universe.mapper.TravelGroupMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/19.
 */
@Service
public class TravelGroupService{

    @Autowired
    private TravelGroupMapper travelGroupmapper;

    //新增
    public void addTravelGroup(TravelGroup travelGroup) {
        boolean flag = this.travelGroupmapper.insert(travelGroup) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteTravelGroup(Integer id) {
        boolean flag = this.travelGroupmapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateTravelGroup(TravelGroup travelGroup) {
        boolean flag =this.travelGroupmapper.updateByPrimaryKeySelective(travelGroup) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<TravelGroup> getAllTravelGroup() {
        List<TravelGroup> list = this.travelGroupmapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public TravelGroup getTravelGroup(Integer id){
        TravelGroup TravelGroup = this.travelGroupmapper.selectByPrimaryKey(id);
        if (TravelGroup == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return TravelGroup;
    }

    //字段搜索
     public List<TravelGroup> searchTravelGroup(String keywords) {
        Example example = new Example(TravelGroup.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<TravelGroup> list = this.travelGroupmapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
