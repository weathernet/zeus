package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "house_label")
@ApiModel(value = "房源特点标签模型", description = "备注")
public class HouseLabel {
    @Id
    @Column(name = "label_id")
    @ApiModelProperty(value = "主键")
    private Integer labelId;

    @Column(name = "label_name")
    @ApiModelProperty(value = "标签的名称", required = true)
    private String labelName;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}