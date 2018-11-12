package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "user_collection")
@ApiModel(value = "用户收藏模型", description = "用户收藏信息")
public class UserCollection {
    @ApiModelProperty(value = "收藏ID")
    @Id
    @Column(name = "collection_id")
    private Integer collectionId;

    @ApiModelProperty(value = "收藏用户")
    @Column(name = "collection_user_id")
    private String collectionUserId;

    @ApiModelProperty(value = "房间的ID")
    @Column(name = "collection_housing_id")
    private Integer collectionHousingId;

    @ApiModelProperty(value = "房间的图片")
    @Column(name = "collection_housing_image")
    private String collectionHousingImage;

    @ApiModelProperty(value = "房间的价格")
    @Column(name = "collection_housing_price")
    private BigDecimal collectionHousingPrice;

    @ApiModelProperty(value = "房间的标题")
    @Column(name = "collection_housing_title")
    private String collectionHousingTitle;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;


}