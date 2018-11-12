package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "house_listing")
@Data
@ApiModel(value = "房源信息模型", description = "房源信息")
public class HouseListing {

    @Id
    @ApiModelProperty(value = "房源的ID")
    @Column(name = "housing_id")
    private Integer housingId;


    @ApiModelProperty(value = "房源的图片", required = true)
    @Column(name = "housing_image")
    private String housingImage;


    @ApiModelProperty(value = "房源的标题", required = true)
    @Column(name = "housing_title")
    private String housingTitle;

    @ApiModelProperty(value = "房源所在城市", required = true)
    @Column(name = "housing_city")
    private String housingCity;

    @ApiModelProperty(value = "房源位置", required = true)
    @Column(name = "housing_position")
    private String housingPosition;

    @ApiModelProperty(value = "房源所在小区", required = true)
    @Column(name = "housing_community")
    private String housingCommunity;

    @ApiModelProperty(value = "房源的名称", required = true)
    @Column(name = "housing_name")
    private String housingName;

    @ApiModelProperty(value = "房源的价格", required = true)
    @Column(name = "housing_price")
    private String housingPrice;

    @ApiModelProperty(value = "住房楼层", required = true)
    @Column(name = "housing_floor")
    private String housingFloor;

    @ApiModelProperty(value = "面积", required = true)
    @Column(name = "housing_area")
    private String housingArea;

    @ApiModelProperty(value = "户型如:三室一厅", required = true)
    @Column(name = "housing_type")
    private String housingType;

    @ApiModelProperty(value = " 电梯0没有1有", required = true)
    @Column(name = "housing_elevator")
    private Integer housingElevator;

    @ApiModelProperty(value = " 简介", required = true)
    @Column(name = "housing_Introduction")
    private String housingIntroduction;

    @ApiModelProperty(value = " 房源标签", required = true)
    @Column(name = "housing_label")
    private String housingLabel;

    @ApiModelProperty(value = " 房源交通交通", required = true)
    @Column(name = "housing_traffic")
    private String housingTraffic;

    @ApiModelProperty(value = " 经度")
    @Column(name = "housing_longitude")
    private String housingLongitude;

    @ApiModelProperty(value = " 纬度")
    @Column(name = "housing_latitude")
    private String housingLatitude;

    @ApiModelProperty(value = " 出租状态：0未出租；1已出租", required = true)
    @Column(name = "housing_live_status")
    private String housingLiveStatus;

    @ApiModelProperty(value = " 租用类型：0短租;1长租;2合租", required = true)
    @Column(name = "housing_lease_type")
    private String housingLeaseType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}