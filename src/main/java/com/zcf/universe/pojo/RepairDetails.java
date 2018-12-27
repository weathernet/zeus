package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "repair_details")
@ApiModel(value = "维修详情模型", description = "备注")
public class RepairDetails {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer detailsId;
    @ApiModelProperty(value = "维修父标题")
    private Integer repairMenuId;
    @ApiModelProperty(value = "维修子菜单")
    private Integer repairSubmenuId;
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