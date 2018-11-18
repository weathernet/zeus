package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Created by YuanQJ on 2018/11/18.
 */
@Data
@Table(name = "mall_banner")
@ApiModel(value = "商城轮播图模型", description = "备注")
public class MallBanner{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer bannerId;

    @ApiModelProperty(value = "轮播图")
    private String bannerImage;

    @ApiModelProperty(value = "轮播地址")
    private String bannerUrl;

}
