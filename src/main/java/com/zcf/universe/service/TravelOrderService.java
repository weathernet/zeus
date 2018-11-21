package com.zcf.universe.service;

import com.zcf.universe.pojo.TravelOrder;
import com.zcf.universe.mapper.TravelOrderMapper;
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
public class TravelOrderService{

    @Autowired
    private TravelOrderMapper travelOrdermapper;

    //新增
    public void addTravelOrder(TravelOrder travelOrder) {
        int count  = this.travelOrdermapper.insert(travelOrder) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteTravelOrder(Integer id) {
        int count  = this.travelOrdermapper.deleteByPrimaryKey(id) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateTravelOrder(TravelOrder travelOrder) {
        int count  =this.travelOrdermapper.updateByPrimaryKeySelective(travelOrder) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<TravelOrder> getAllTravelOrder() {
        List<TravelOrder> list = this.travelOrdermapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public TravelOrder getTravelOrder(Integer id){
        TravelOrder TravelOrder = this.travelOrdermapper.selectByPrimaryKey(id);
        if (TravelOrder == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return TravelOrder;
    }

    //字段搜索
     public List<TravelOrder> searchTravelOrder(String keywords) {
        Example example = new Example(TravelOrder.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<TravelOrder> list = this.travelOrdermapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
