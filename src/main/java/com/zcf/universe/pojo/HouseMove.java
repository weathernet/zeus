package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "move_house")
@ApiModel(value = "搬家选择模型", description = "备注")
public class HouseMove {
    @Id
    @Column(name = "move_id")
    @ApiModelProperty(value = "主键")
    private Integer moveId;

    @Column(name = "move_name")
    @ApiModelProperty(value = "名称")
    private String moveName;

    @Column(name = "move_price")
    @ApiModelProperty(value = "价格")
    private String movePrice;

    @Column(name = "move_image")
    @ApiModelProperty(value = "图片")
    private String moveImage;

    @Column(name = "move_title1")
    @ApiModelProperty(value = "标题1")
    private String moveTitle1;

    @Column(name = "move_title2")
    @ApiModelProperty(value = "标题2")
    private String moveTitle2;

    @Column(name = "move_title3")
    @ApiModelProperty(value = "标题3")
    private String moveTitle3;

    @Column(name = "move_sub_title1")
    @ApiModelProperty(value = "副标题1")
    private String moveSubTitle1;

    @Column(name = "move_sub_title2")
    @ApiModelProperty(value = "副标题2")
    private String moveSubTitle2;

    @Column(name = "move_sub_title3")
    @ApiModelProperty(value = "副标题3")
    private String moveSubTitle3;

}