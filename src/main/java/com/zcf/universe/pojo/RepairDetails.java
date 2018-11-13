package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "repair_details")
@ApiModel(value = "维修详情模型", description = "维修详情")
public class RepairDetails {
    @Id
    @Column(name = "details_id")
    @ApiModelProperty(value = "主键")
    private Integer detailsId;

    @Column(name = "repair_menu_id")
    @ApiModelProperty(value = "主菜单")
    private Integer repairMenuId;

    @Column(name = "repair_submenu_id")
    @ApiModelProperty(value = "父菜单")
    private Integer repairSubmenuId;

    @Column(name = "details_title")
    @ApiModelProperty(value = "标题")
    private String detailsTitle;

    @ApiModelProperty(value = "图片")
    @Column(name = "details_image")
    private String detailsImage;

    @ApiModelProperty(value = "服务内容")
    @Column(name = "details_service")
    private String detailsService;

    @ApiModelProperty(value = "价格")
     @Column(name = "details_price")
     private String detailsPrice;

}