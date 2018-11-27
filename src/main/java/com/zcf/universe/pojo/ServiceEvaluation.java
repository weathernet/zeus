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
@Table(name = "service_evaluation")
@ApiModel(value = "ServiceEvaluation模型", description = "ServiceEvaluation信息")
public class ServiceEvaluation {

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer evaluateId;

    @ApiModelProperty(value = "用户ID")
    private Integer evaluateUserId;

    @ApiModelProperty(value = "用户昵称")
    private String evaluateUserNickName;

    @ApiModelProperty(value = "类型0.维修服务1.搬家服务3.保洁服务")
    private Integer evaluateType;

    @ApiModelProperty(value = "照片")
    private String evaluateImage;

    @ApiModelProperty(value = "评价的内容")
    private String evaluateContent;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
