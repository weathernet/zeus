package com.zcf.universe.service;

import com.zcf.universe.pojo.TravelTicket;
import com.zcf.universe.mapper.TravelTicketMapper;
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
public class TravelTicketService{

    @Autowired
    private TravelTicketMapper travelTicketmapper;

    //新增
    public void addTravelTicket(TravelTicket travelTicket) {
        boolean flag = this.travelTicketmapper.insert(travelTicket) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteTravelTicket(Integer id) {
        boolean flag = this.travelTicketmapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateTravelTicket(TravelTicket travelTicket) {
        boolean flag =this.travelTicketmapper.updateByPrimaryKeySelective(travelTicket) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<TravelTicket> getAllTravelTicket() {
        List<TravelTicket> list = this.travelTicketmapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public TravelTicket getTravelTicket(Integer id){
        TravelTicket TravelTicket = this.travelTicketmapper.selectByPrimaryKey(id);
        if (TravelTicket == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return TravelTicket;
    }

    //字段搜索
     public List<TravelTicket> searchTravelTicket(String keywords) {
        Example example = new Example(TravelTicket.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<TravelTicket> list = this.travelTicketmapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
