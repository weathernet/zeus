package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by YuanQJ on 2018/11/28.
 */
@Data
@Table(name = "housing_butler")
@ApiModel(value = "HousingButler模型", description = "HousingButler信息")
public class HousingButler {

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer butlerId;

    @ApiModelProperty(value = "管家姓名")
    private String butlerName;

    @ApiModelProperty(value = "管家的图片")
    private String butlerImage;

    @ApiModelProperty(value = "手机号")
    private String butlerPhone;

    @ApiModelProperty(value = "管家的介绍")
    private String butlerIntroduction;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
