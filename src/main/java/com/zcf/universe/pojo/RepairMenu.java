package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "repair_menu")
@ApiModel(value = "维修主菜单模型", description = "维修主菜单")
public class RepairMenu {
    @Id
    @Column(name = "repair_id")
    @ApiModelProperty(value = "主键")
    private Integer repairId;

    @Column(name = "repair_name")
    @ApiModelProperty(value = "父类名")
    private String repairName;

    @Column(name = "repair_image")
    @ApiModelProperty(value = "图片")
    private String repairImage;

}