package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "user_order")
@ApiModel(value = "用户订单模型", description = "备注")
public class UserOrder {
    /**
     * 订单号
     */
    @Id
    @Column(name = "order_id")
    @ApiModelProperty(value = "订单ID")
    private Integer orderId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "order_user_id")
    private Integer orderUserId;


    @ApiModelProperty(value = "状态:0房源订单1:商品订单")
    @Column(name = "order_type")
    private Integer orderType;

    @ApiModelProperty(value = "商品ID")
    @Column(name = "order_goods_id")
    private Integer orderGoodsId;

    @ApiModelProperty(value = "商品标题")
    @Column(name = "order_goods_title")
    private String orderGoodsTitle;

    @ApiModelProperty(value = "商品照片")
    @Column(name = "order_goods_image")
    private String orderGoodsImage;

    @ApiModelProperty(value = "商品价格")
    @Column(name = "order_goods_price")
    private String orderGoodsPrice;

    @ApiModelProperty(value = "订单状态0.未付款1.待发货2待收货3待评价4已完成")
    @Column(name = "order_goods_status")
    private String orderGoodsStatus;

    @ApiModelProperty(value = "收货人手机号")
    @Column(name = "order_user_phone")
    private String orderUserPhone;

    @ApiModelProperty(value = "收货人地址")
    @Column(name = "order_user_address")
    private String orderUserAddress;

    @ApiModelProperty(value = "快递公司")
    @Column(name = "order_courier_company")
    private String orderCourierCompany;

    @ApiModelProperty(value = "快递单号")
    @Column(name = "order_courier_number")
    private String orderCourierNumber;

    @ApiModelProperty(value = "房源Id")
    @Column(name = "order_housing_id")
    private Integer orderHousingId;

    @ApiModelProperty(value = "房源标题")
    @Column(name = "order_housing_title")
    private String orderHousingTitle;

    @ApiModelProperty(value = "房源图片")
    @Column(name = "order_housing_image")
    private String orderHousingImage;

    @ApiModelProperty(value = "房屋合约开始时间")
    @Column(name = "order_housing_start_time")
    private String orderHousingStartTime;

    @ApiModelProperty(value = "租房合约的结束时间")
    @Column(name = "order_housing_end_time")
    private String orderHousingEndTime;

    @ApiModelProperty(value = "租金")
    @Column(name = "order_housing_price")
    private String orderHousingPrice;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}