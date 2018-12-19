package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
* @author YuanQJ
* @date 2018/12/18
*/
@Data
@Table(name = "integral_record")
@ApiModel(value = "IntegralRecord模型", description = "IntegralRecord信息")
public class IntegralRecord{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer recordId;

    @ApiModelProperty(value = "用户主键")
    private Integer recordUserId;

    @ApiModelProperty(value = "状态")
    private String recordType;
    @ApiModelProperty(value = "名称用户")
    private String recordUserName;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "积分的增减")
    private String recordIntegral;
}
