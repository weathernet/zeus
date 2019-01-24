package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by YuanQJ on 2018/11/18.
 */
@Data
@Table(name = "mall_goods")
@ApiModel(value = "商城商品模型", description = "备注")
public class MallGoods{
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer goodsId;
    @ApiModelProperty(value = "商户Id")
    private Integer goodsTraderId;
    @ApiModelProperty(value = "商品标题")
    private String goodsTitle;
    @ApiModelProperty(value = "商品图片")
    private String goodsImage;
    @ApiModelProperty(value = "商品图片详情")
    private String goodsDetailsImages;
    @ApiModelProperty(value = "单价")
    private String goodsPrice;
    @ApiModelProperty(value = "商品分类")
    private Integer goodsGroups;
    @ApiModelProperty(value = "状态:0.待审核1.已通过2.未通过")
    private String goodsStatus;
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;
}
