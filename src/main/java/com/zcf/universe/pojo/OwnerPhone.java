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
@Table(name = "owner_phone")
@ApiModel(value = "业主电话模型", description = "业主电话信息")
public class OwnerPhone {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer id;
    @ApiModelProperty(value = "手机号")
    private String telephone;
}
