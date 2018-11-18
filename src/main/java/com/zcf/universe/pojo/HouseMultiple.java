package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "house_multiple")
@ApiModel(value = "佣金模型", description = "备注")
public class HouseMultiple {

    @ApiModelProperty(value = "佣金比例ID")
    @Id
    @Column(name = "multiple_id")
    private Integer multipleId;

    @ApiModelProperty(value = "佣金比例")
    @Column(name = "multiple_proportion")
    private Double multipleProportion;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "uptate_time")
    private Date uptateTime;


}