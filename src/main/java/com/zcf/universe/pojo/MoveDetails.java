package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "move_details")
@ApiModel(value = "搬家详情模型", description = "备注")
public class MoveDetails {
    @Id
    @Column(name = "details_id")
    @ApiModelProperty(value = "主键")
    private Integer detailsId;
    @ApiModelProperty(value = "维修标题")
    private String detailsTitle;
    @ApiModelProperty(value = "介绍的图片")
    private String detailsImage;
    @ApiModelProperty(value = "服务介绍")
    private String detailsIntroduction;
    @ApiModelProperty(value = "价格")
    private String detailsPrice;
    @ApiModelProperty(value = "维修范围")
    private String detailsRange;

}