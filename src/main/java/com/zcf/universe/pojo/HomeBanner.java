package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "home_banner")
@ApiModel(value = "首页轮播模型", description = "轮播信息")
public class HomeBanner {
    @Id
    @Column(name = "banner_id")
    @ApiModelProperty(value = "主键", required = true)
    private Integer bannerId;

    @ApiModelProperty(value = "轮播的图片")
    @Column(name = "banner_picture")
    private String bannerPicture;

    @ApiModelProperty(value = "跳转的地址")
    @Column(name = "banner_url")
    private String bannerUrl;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}