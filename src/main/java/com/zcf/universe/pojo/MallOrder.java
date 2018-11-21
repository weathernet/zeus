package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * Created by YuanQJ on 2018/11/18.
 */
@Data
@Table(name = "mall_order")
@ApiModel(value = "商城订单模型", description = "备注")
public class MallOrder{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Long orderId;

    @ApiModelProperty(value = "用户ID")
    private Integer orderUserId;

    @ApiModelProperty(value = "商户的ID")
    private Integer orderTraderId;

    @ApiModelProperty(value = "收货人电话")
    private String orderPhone;

    @ApiModelProperty(value = "收货地址")
    private String orderAddress;

    @ApiModelProperty(value = "快递公司")
    private String orderCompany;

    @ApiModelProperty(value = "快递单号")
    private String orderExpressNumber;

    @ApiModelProperty(value = "订单状态0.未付款1.待发货.2.待收货3.待评价4.已完成")
    private Integer orderStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "g更新时间")
    private Date updateTime;

}
