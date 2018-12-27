package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by YuanQJ on 2018/11/19.
 */
@Data
@Table(name = "travel_evaluate")
@ApiModel(value = "景点评论模型", description = "景点评论信息")
public class TravelEvaluate {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer evaluateId;
    @ApiModelProperty(value = "用户主键")
    private Integer evaluateUserId;
    @ApiModelProperty(value = "景点的主键")
    private Integer evaluateSceneryId;
    @ApiModelProperty(value = "用户昵称")
    private String evaluateUserNickName;
    @ApiModelProperty(value = "用户头像")
    private String evaluateHeadPortrait;
    @ApiModelProperty(value = "评价图片")
    private String evaluateImage;
    @ApiModelProperty(value = "评分")
    private String evaluateScore;
    @ApiModelProperty(value = "评价内容")
    private String evaluateContent;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
