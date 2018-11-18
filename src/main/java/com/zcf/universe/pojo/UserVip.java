package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@ApiModel(value = "会员模型", description = "备注")
@Table(name = "user_vip")
public class UserVip {

    @ApiModelProperty(value = "会员ID")
    @Id
    @Column(name = "vip_id")
    private Integer vipId;

    @ApiModelProperty(value = "会员名称")
    @Column(name = "vip_name")
    private String vipName;

    @ApiModelProperty(value = "会员折扣")
    @Column(name = "vip_discount")
    private String vipDiscount;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}