package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "move_details")
@ApiModel(value = "搬家详情模型", description = "备注")
public class MoveDetails {
    @Id
    @Column(name = "details_id")
    @ApiModelProperty(value = "主键")
    private Integer detailsId;

    @Column(name = "details_content")
    @ApiModelProperty(value = "搬家的详情")
    private String detailsContent;

}