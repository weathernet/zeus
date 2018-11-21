package com.zcf.universe.mapper;


import com.zcf.universe.pojo.HouseListing;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HouseListingMapper extends Mapper<HouseListing> {
    @Results({
            @Result(property = "housingId", column = "housing_id"),
            @Result(property = "housingImage", column = "housing_image"),
            @Result(property = "housingTitle", column = "housing_title"),
            @Result(property = "housingCity", column = "housing_city"),
            @Result(property = "housingDirection", column = "housing_direction"),
            @Result(property = "housingPosition", column = "housing_position"),
            @Result(property = "housingCommunity", column = "housing_community"),
            @Result(property = "housingName", column = "housing_name"),
            @Result(property = "housingPrice", column = "housing_price"),
            @Result(property = "housingFloor", column = "housing_floor"),
            @Result(property = "housingArea", column = "housing_area"),
            @Result(property = "housingType", column = "housing_type"),
            @Result(property = "housingElevator", column = "housing_elevator"),
            @Result(property = "housingIntroduction", column = "housing_Introduction"),
            @Result(property = "housingLabel", column = "housing_label"),
            @Result(property = "housingTraffic", column = "housing_traffic"),
            @Result(property = "housingLongitude", column = "housing_longitude"),
            @Result(property = "housingLatitude", column = "housing_latitude"),
            @Result(property = "housingLiveStatus", column = "housing_live_status"),
            @Result(property = "housingLeaseType", column = "housing_lease_type"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    @Select("SELECT  * " +
            "FROM house_listing WHERE " +
            "ROUND(6378.138 * 2 * ASIN(SQRT(POW(SIN((#{latitude}* PI() / 180 - housing_latitude * PI() / 180) / 2),2) \n" +
            "+COS(#{latitude} * PI() / 180) * COS(housing_latitude * PI() / 180) * POW(" +
            "SIN((#{longitude} * PI() / 180 - housing_longitude * PI() / 180) / 2),2))) * 1000)" +
            "< #{range}")
    List<HouseListing> mapLookingForRoom(@Param("longitude")String longitude,
                               @Param("latitude")String latitude,
                               @Param("range")Integer range);
}