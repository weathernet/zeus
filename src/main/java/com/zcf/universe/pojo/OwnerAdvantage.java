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
@Table(name = "owner_advantage")
@ApiModel(value = "品家优势模型", description = "品家优势信息")
public class OwnerAdvantage {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer id;
    @ApiModelProperty(value = "品家推荐照片")
    private String advantage;
}
