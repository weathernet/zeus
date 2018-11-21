package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.MoveOrderMapper;
import com.zcf.universe.pojo.MoveOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/15.
 */
@Service
public class MoveOrderService {

    @Autowired
    private MoveOrderMapper moveOrdermapper;

    //新增
    public void addMoveOrder(MoveOrder moveOrder) {
        int count = this.moveOrdermapper.insertSelective(moveOrder) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMoveOrder(Integer id) {
        int count = this.moveOrdermapper.deleteByPrimaryKey(id) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMoveOrder(MoveOrder moveOrder) {
        int count =this.moveOrdermapper.updateByPrimaryKeySelective(moveOrder) ;
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<MoveOrder> getAllMoveOrder() {
        List<MoveOrder> list = this.moveOrdermapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public MoveOrder getMoveOrder(Integer id){
        MoveOrder MoveOrder = this.moveOrdermapper.selectByPrimaryKey(id);
        if (MoveOrder == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MoveOrder;
    }

    //字段搜索
     public List<MoveOrder> searchMoveOrder(String keywords) {
        Example example = new Example(MoveOrder.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<MoveOrder> list = this.moveOrdermapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
