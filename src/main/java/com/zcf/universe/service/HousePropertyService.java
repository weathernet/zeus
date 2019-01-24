package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HousePropertyMapper;
import com.zcf.universe.pojo.HouseProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 袁齐吉
 * @date 2018/12/28
 */
@Service
public class HousePropertyService {

    @Autowired
    private HousePropertyMapper housePropertymapper;


    //查询所有
    public List<HouseProperty> getAllHouseProperty() {
        List<HouseProperty> list = this.housePropertymapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }


    //字段搜索
    public List<HouseProperty> searchHousePropertyByCity(String city) {
        Example example = new Example(HouseProperty.class);
        example.createCriteria().andLike("city", "%" + city + "%");//name为你想要搜索的字段
        List<HouseProperty> list = this.housePropertymapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }

    public List<HouseProperty> getAllHousePropertyByStatus(String city, String type) {
        Example example = new Example(HouseProperty.class);
        example.createCriteria().andLike("city", "%" + city + "%").andEqualTo("type", type);//name为你想要搜索的字段
        List<HouseProperty> list = this.housePropertymapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }

    public List<HouseProperty> searchHouses(String type, String city, Integer min, Integer max, String group, boolean desc) {
        //非空验证
        if (StringUtils.isBlank(city)) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //创建查询条件
        Example example = new Example(HouseProperty.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("city", "%" + city + "%").andEqualTo("type", type);
        //设置金额的范围
        if (min != null && max != null) {
            criteria.andBetween("sunPrice", min, max);
        } else if (min != null && max == null) {
            criteria.andGreaterThanOrEqualTo("sunPrice", min);
        } else if (min == null && max != null) {
            criteria.andLessThanOrEqualTo("sunPrice", max);
        }
        //排序
        if (StringUtils.isNotBlank(group)) {
            String orderByClause = group + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }

        List<HouseProperty> list = this.housePropertymapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LABEL_BE_REPEAT);
        }
        return list;
    }
}

