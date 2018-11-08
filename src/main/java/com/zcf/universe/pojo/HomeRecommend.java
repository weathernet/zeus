package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "home_recommend")
@ApiModel(value = "首页推荐模型", description = "推荐信息")
public class HomeRecommend {
    @ApiModelProperty(value = "主键")
    @Id
    @Column(name = "recommend_id")
    private Integer recommendId;

    @ApiModelProperty(value = "推荐标题")
    @Column(name = "recommend_title")
    private String recommendTitle;

    @ApiModelProperty(value = "推荐简介")
    @Column(name = "recommend_Introduction")
    private String recommendIntroduction;

    @ApiModelProperty(value = "图片")
    @Column(name = "recommend_image")
    private String recommendImage;

    @ApiModelProperty(value = "推荐类型:0短租推荐,1长租推荐,2写字楼推荐,3商业推荐")
    @Column(name = "recommend_type")
    private String recommendType;

    @ApiModelProperty(value = "跳转页面")
    @Column(name = "recommend_url")
    private String recommendUrl;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}