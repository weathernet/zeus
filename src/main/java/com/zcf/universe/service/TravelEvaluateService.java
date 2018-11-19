package com.zcf.universe.service;

import com.zcf.universe.pojo.TravelEvaluate;
import com.zcf.universe.mapper.TravelEvaluateMapper;
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
public class TravelEvaluateService{

    @Autowired
    private TravelEvaluateMapper travelEvaluatemapper;

    //新增
    public void addTravelEvaluate(TravelEvaluate travelEvaluate) {
        boolean flag = this.travelEvaluatemapper.insert(travelEvaluate) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteTravelEvaluate(Integer id) {
        boolean flag = this.travelEvaluatemapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateTravelEvaluate(TravelEvaluate travelEvaluate) {
        boolean flag =this.travelEvaluatemapper.updateByPrimaryKeySelective(travelEvaluate) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<TravelEvaluate> getAllTravelEvaluate() {
        List<TravelEvaluate> list = this.travelEvaluatemapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public TravelEvaluate getTravelEvaluate(Integer id){
        TravelEvaluate TravelEvaluate = this.travelEvaluatemapper.selectByPrimaryKey(id);
        if (TravelEvaluate == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return TravelEvaluate;
    }

    //字段搜索
     public List<TravelEvaluate> searchTravelEvaluate(String keywords) {
        Example example = new Example(TravelEvaluate.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<TravelEvaluate> list = this.travelEvaluatemapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}