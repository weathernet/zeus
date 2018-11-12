package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "house_reserve")
@ApiModel(value = "房屋预约模型", description = "房屋预约")
public class HouseReserve {

    @ApiModelProperty(value = " ID")
    @Id
    @Column(name = "reserve_id")
    private Integer reserveId;

    @ApiModelProperty(value = "用户的ID")
    @Column(name = "reserve_user_id")
    private Integer reserveUserId;

    @ApiModelProperty(value = "用户的名称")
    @Column(name = "reserve_user_name")
    private String reserveUserName;

    @ApiModelProperty(value = "用户的手机号")
    @Column(name = "reserve_user_phone")
    private String reserveUserPhone;

    @ApiModelProperty(value = "用户的性别:0女：1：男")
    @Column(name = "reserve_user_gender")
    private Integer reserveUserGender;

    @ApiModelProperty(value = "所预约的房源ID")
    @Column(name = "reserve_house_id")
    private Integer reserveHouseId;

    @ApiModelProperty(value = "房屋的标题")
    @Column(name = "reserve_house_title")
    private String reserveHouseTitle;

    @ApiModelProperty(value = "房屋的图片")
    @Column(name = "reserve_house_image")
    private String reserveHouseImage;

    @ApiModelProperty(value = "面积")
    @Column(name = "reserve_house_area")
    private String reserveHouseArea;

    @ApiModelProperty(value = "房屋的价格")
    @Column(name = "reserve_house_price")
    private String reserveHousePrice;

    @ApiModelProperty(value = "预约时间")
    @Column(name = "reserve_time")
    private String reserveTime;

    @ApiModelProperty(value = "留言")
    @Column(name = "reserve_message")
    private String reserveMessage;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}