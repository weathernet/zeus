package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 袁齐吉
 * @date 2018/12/28
 */
@Data
@Table(name = "house_property")
@ApiModel(value = "HouseProperty模型", description = "HouseProperty信息")
public class HouseProperty {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer id;
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty(value = "价格")
    private String sunPrice;
    @ApiModelProperty(value = "图片")
    private String image;
    @ApiModelProperty(value = "是否可已注册")
    private String register;
    @ApiModelProperty(value = "单价")
    private String price;
    @ApiModelProperty(value = "看房日期")
    private String lookTime;
    @ApiModelProperty(value = "租期")
    private String leaseTerm;
    @ApiModelProperty(value = "面积")
    private String area;
    @ApiModelProperty(value = "房产优势")
    private String advantage;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "装修情况")
    private String renovation;
    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "物业费")
    private String property;
    @ApiModelProperty(value = "简介")
    private String introduction;
    @ApiModelProperty(value = "收费标准")
    private String standard;
    @ApiModelProperty(value = "管家主键")
    private Integer butlerId;
    @ApiModelProperty(value = "类型1.写字楼2.商业3厂房4.房产")
    private String type;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
