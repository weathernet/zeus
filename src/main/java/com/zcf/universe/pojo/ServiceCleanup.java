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
@ApiModel(value = "ServiceCleanup模型", description = "ServiceCleanup信息")
public class ServiceCleanup {

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer cleanupId;

    @ApiModelProperty(value = "保洁详情")
    private String cleanupContent;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
