package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@Data
@Table(name = "owner_entrust")
@ApiModel(value = "在线委托模型", description = "在线委托信息")
public class OwnerEntrust {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer id;
    @ApiModelProperty(value = "用户Id")
    private Integer userId;
    @ApiModelProperty(value = "城市名称")
    private String cityName;
    @ApiModelProperty(value = "小区")
    private String region;
    @ApiModelProperty(value = "联系电话")
    private String phone;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "信息")
    private String information;
}
