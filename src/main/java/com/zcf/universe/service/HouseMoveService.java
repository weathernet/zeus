package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HouseMoveMapper;
import com.zcf.universe.pojo.HouseMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/14.
 */
@Service
public class HouseMoveService {

    @Autowired
    private HouseMoveMapper houseMovemapper;

    //查询所有
    public List<HouseMove> getAllHouseMove() {
        List<HouseMove> list = this.houseMovemapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public HouseMove getHouseMove(Integer id){
        HouseMove HouseMove = this.houseMovemapper.selectByPrimaryKey(id);
        if (HouseMove == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return HouseMove;
    }

    //字段搜索
     public List<HouseMove> searchHouseMove(String keywords) {
        Example example = new Example(HouseMove.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<HouseMove> list = this.houseMovemapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
