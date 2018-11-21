package com.zcf.universe.service;

import com.zcf.universe.pojo.TravelPeople;
import com.zcf.universe.mapper.TravelPeopleMapper;
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
public class TravelPeopleService {

    @Autowired
    private TravelPeopleMapper travelPeoplemapper;

    //新增
    public void addTravelPeople(TravelPeople travelPeople) {
        int count = this.travelPeoplemapper.insert(travelPeople);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteTravelPeople(Integer id) {
        int count = this.travelPeoplemapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateTravelPeople(TravelPeople travelPeople) {
        int count = this.travelPeoplemapper.updateByPrimaryKeySelective(travelPeople);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<TravelPeople> getAllTravelPeople() {
        List<TravelPeople> list = this.travelPeoplemapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public TravelPeople getTravelPeople(Integer id) {
        TravelPeople TravelPeople = this.travelPeoplemapper.selectByPrimaryKey(id);
        if (TravelPeople == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return TravelPeople;
    }

    //字段搜索
    public List<TravelPeople> searchTravelPeople(String keywords) {
        Example example = new Example(TravelPeople.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<TravelPeople> list = this.travelPeoplemapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
