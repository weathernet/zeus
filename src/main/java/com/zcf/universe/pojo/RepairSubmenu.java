package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "repair_submenu")
@ApiModel(value = "维修子菜单模型", description = "维修子菜单")
public class RepairSubmenu {

    @Id
    @Column(name = "repair_sub_id")
    @ApiModelProperty(value = "子菜单主键")
    private Integer repairSubId;

    @Column(name = "repair_menu_id")
    @ApiModelProperty(value = "父菜单主键")
    private Integer repairMenuId;

    @ApiModelProperty(value = "子菜单名称")
    @Column(name = "repair_sub_name")
    private String repairSubName;

    @Column(name = "repair_sub_image")
    @ApiModelProperty(value = "子菜单的图片")
    private String repairSubImage;


}