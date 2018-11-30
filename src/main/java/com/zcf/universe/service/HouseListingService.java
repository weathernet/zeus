package com.zcf.universe.service;

import com.github.pagehelper.PageHelper;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.HouseLabelMapper;
import com.zcf.universe.mapper.HouseListingMapper;
import com.zcf.universe.mapper.UserInfoMapper;
import com.zcf.universe.mapper.UserSearchHistoryMapper;
import com.zcf.universe.pojo.HouseLabel;
import com.zcf.universe.pojo.HouseListing;
import com.zcf.universe.pojo.UserSearchHistory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author yuan
 * @date 2018/11/6 0006
 */
@Service
@Transactional
public class HouseListingService {
    @Autowired
    private HouseListingMapper houseListingMapper;

    @Autowired
    private HouseLabelMapper houseLabelMapper;

    @Autowired
    private UserSearchHistoryMapper userSearchHistorymapper;
    @Autowired
    private UserInfoMapper userInfomapper;

    //查询房源
    public List<HouseListing> getHouseListings(Integer page, Integer rows, String sortBy, boolean desc, String key, String city, Integer userId) {
        //分页
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(HouseListing.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isBlank(city)) {
            throw new CommonException(ExceptionEnum.CITY_BE_NULL);
        }
        criteria.andEqualTo("housingCity", city);


        if (StringUtils.isNotBlank(key)) {
            criteria.orLike("housingTitle", "%" + key + "%");
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<HouseListing> list = this.houseListingMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //新增房源
    public boolean addHouseListing(HouseListing houseListing) {
        return this.houseListingMapper.insertSelective(houseListing) == 1;

    }

    //更新房源
    public void updateHouseListing(Integer id, HouseListing houseListing) {
        houseListing.setHousingId(id);
        this.houseListingMapper.updateByPrimaryKey(houseListing);
    }

    //获取房源的具体的信息
    public HouseListing getHouseListing(Integer id) {
        HouseListing houseListing = this.houseListingMapper.selectByPrimaryKey(id);
        if (houseListing == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return houseListing;
    }

    public List<HouseLabel> getHouseLabel() {
        List<HouseLabel> list = this.houseLabelMapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LABEL_BE_REPEAT);
        }
        return list;
    }

    public List<HouseListing> mapLookingForRoom(String longitude, String latitude, Integer range) {
        List<HouseListing> list = this.houseListingMapper.mapLookingForRoom(longitude, latitude, range);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LABEL_BE_REPEAT);
        }
        return list;
    }

    //搜索房源
    public List<HouseListing> searchHouses(String keyWords, String city, Integer min, Integer max, String group, boolean desc) {
        //非空验证
        if (StringUtils.isBlank(keyWords) && StringUtils.isBlank(city)) {
            throw new CommonException(ExceptionEnum.PARAMETER_CAN_NOT_BE_EMPTY);
        }
        //创建查询条件
        Example example = new Example(HouseListing.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("housingCity", "%" + city + "%")
                .andLike("housingTitle", "%" + keyWords + "%");
        //设置金额的范围
        if (min != null && max != null) {
            criteria.andBetween("housingPrice", min, max);
        } else if (min != null && max == null) {
            criteria.andGreaterThanOrEqualTo("housingPrice", min);
        } else if (min == null && max != null) {
            criteria.andLessThanOrEqualTo("housingPrice", max);
        }
        //排序
        if (StringUtils.isNotBlank(group)) {
            String orderByClause = group + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }

        List<HouseListing> list = this.houseListingMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LABEL_BE_REPEAT);
        }
        return list;
    }
}
