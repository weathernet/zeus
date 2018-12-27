package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * Created by YuanQJ on 2018/11/19.
 */
@Data
@Table(name = "travel_order")
@ApiModel(value = "旅游订单模型", description = "旅游订单信息")
public class TravelOrder{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer orderId;

    @ApiModelProperty(value = "用户主键")
    private Integer orderUserId;

    @ApiModelProperty(value = "旅游的人")
    private String orderPeopleId;

    @ApiModelProperty(value = "门票数量")
    private Integer orderNumber;

    @ApiModelProperty(value = "总价")
    private String orderSumPrice;

    @ApiModelProperty(value = "门票标题")
    private String orderTitle;

    @ApiModelProperty(value = "使用日期")
    private String orderServiceDate;

    @ApiModelProperty(value = "订单状态")
    private String orderState;//订单状态 0代付款 1待使用 2已使用 3已过期

    @ApiModelProperty(value = "支付类型")
    private String orderPaytype;//支付类型 1微信支付 2支付宝支付 3余额支付

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
