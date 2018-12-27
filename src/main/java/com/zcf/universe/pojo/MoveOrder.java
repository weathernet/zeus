package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "move_order")
@ApiModel(value = "搬家订单模型", description = "搬家订单模型")
public class MoveOrder {
    @Id
    @Column(name = "order_id")
    @ApiModelProperty(value = "主键")
    private Integer orderId;
    @Column(name = "order_user_id")
    @ApiModelProperty(value = "用户的主键")
    private String orderUserId;
    @Column(name = "order_move_out")
    @ApiModelProperty(value = "搬出地址")
    private String orderMoveOut;
    @Column(name = "order_move_into")
    @ApiModelProperty(value = "搬入地址")
    private String orderMoveInto;
    @Column(name = "order_linkman_phone")
    @ApiModelProperty(value = "联系人手机号")
    private String orderLinkmanPhone;
    @Column(name = "order_special")
    @ApiModelProperty(value = "搬家的特殊需求")
    private String orderSpecial;
    @Column(name = "order_move_time")
    @ApiModelProperty(value = "搬家时间")
    private String orderMoveTime;
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @Column(name = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}