package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HousePropertyMapper;
import com.zcf.universe.pojo.HouseProperty;
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

    //新增
    public void addHouseProperty(HouseProperty houseProperty) {
        int count = this.housePropertymapper.insertSelective(houseProperty);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }
    }

    //删除
    public void deleteHousePropertyById(Integer id) {
        int count = this.housePropertymapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.DELETE_FAILURE);
        }
    }

    //更新
    public void updateHouseProperty(HouseProperty houseProperty) {
        int count = this.housePropertymapper.updateByPrimaryKeySelective(houseProperty);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //查询所有
    public List<HouseProperty> getAllHouseProperty() {
        List<HouseProperty> list = this.housePropertymapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }

    //查询单个
    public HouseProperty getHouseProperty(Integer id) {
        HouseProperty HouseProperty = this.housePropertymapper.selectByPrimaryKey(id);
        if (HouseProperty == null) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return HouseProperty;
    }

    //字段搜索
    public List<HouseProperty> searchHouseProperty(String keywords) {
        Example example = new Example(HouseProperty.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<HouseProperty> list = this.housePropertymapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }
}
