package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "home_groups")
@ApiModel(value = "首页分组模型", description = "备注")
public class HomeGroups{
    @Id
    @Column(name = "groups_id")
    @ApiModelProperty(value = "主键", required = true)
    private Integer groupsId;

    @ApiModelProperty(value = "分组名称", required = true)
    @Column(name = "groups_name")
    private String groupsName;

    @ApiModelProperty(value = "图片", required = true)
    @Column(name = "groups_image")
    private String groupsImage;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;


}