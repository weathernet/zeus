package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by YuanQJ on 2018/11/26.
 */
@Data
@Table(name = "service_cleanup")
@ApiModel(value = "清洁模型", description = "清洁信息")
public class ServiceCleanup {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer cleanupId;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "保洁范围")
    private String cleanupRange;
    @ApiModelProperty(value = "保洁价格")
    private String cleanupPrice;
    @ApiModelProperty(value = "保洁介绍")
    private String cleanupIntroduction;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
