package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "repair_cost")
@ApiModel(value = "维修费用模型", description = "维修费用")
public class RepairCost {
    @Id
    @Column(name = "cost_id")
    @ApiModelProperty(value = "主键")
    private Integer costId;

    @Column(name = "cost_sub_menu_id")
    @ApiModelProperty(value = "子标题主键")
    private Integer costSubMenuId;

    @Column(name = "cost_title")
    @ApiModelProperty(value = "标题")
    private String costTitle;

    @Column(name = "cost_sub_title")
    @ApiModelProperty(value = "副标题")
    private String costSubTitle;

    @Column(name = "cost_price")
    @ApiModelProperty(value = "价格")
    private String costPrice;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}