package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HouseReserveMapper;
import com.zcf.universe.pojo.HouseReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/09.
 */
@Service
public class HouseReserveService {

    @Autowired
    private HouseReserveMapper houseReservemapper;

    //新增
    public void addHouseReserve(HouseReserve houseReserve) {
        int count = this.houseReservemapper.insert(houseReserve) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteHouseReserve(Integer id) {
        int count = this.houseReservemapper.deleteByPrimaryKey(id) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateHouseReserve(HouseReserve houseReserve) {
        int count = this.houseReservemapper.updateByPrimaryKeySelective(houseReserve) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<HouseReserve> getAllHouseReserve() {
        List<HouseReserve> list = this.houseReservemapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public HouseReserve getHouseReserve(Integer id) {
        HouseReserve HouseReserve = this.houseReservemapper.selectByPrimaryKey(id);
        if (HouseReserve == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return HouseReserve;
    }

    //字段搜索
    public List<HouseReserve> searchHouseReserve(String keywords) {
        Example example = new Example(HouseReserve.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<HouseReserve> list = this.houseReservemapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
