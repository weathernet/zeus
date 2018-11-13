package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "repair_order")
@ApiModel(value = "维修订单模型", description = "维修订单")
public class RepairOrder {
    @Id
    @Column(name = "order_id")
    @ApiModelProperty(value = "键")
    private Integer orderId;

    @Column(name = "order_price")
    @ApiModelProperty(value = "价格")
    private Long orderPrice;

    @ApiModelProperty(value = "维修的项目")
    @Column(name = "order_project")
    private String orderProject;

    @Column(name = "order_message")
    @ApiModelProperty(value = "故障信息")
    private String orderMessage;

    @Column(name = "order_time")
    @ApiModelProperty(value = "预约时间")
    private String orderTime;

    @Column(name = "order_address")
    @ApiModelProperty(value = "预约地址")
    private String orderAddress;

    @Column(name = "order_linkman_name")
    @ApiModelProperty(value = "联系人")
    private String orderLinkmanName;

    @Column(name = "order_linkman_phone")
    @ApiModelProperty(value = "联系地址")
    private String orderLinkmanPhone;


}