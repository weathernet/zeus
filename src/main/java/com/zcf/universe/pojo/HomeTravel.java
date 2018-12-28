package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 袁齐吉
 * @date 2018/12/28
 */
@Data
@Table(name = "home_travel")
@ApiModel(value = "首页推荐旅行模型", description = "首页推荐旅行信息")
public class HomeTravel {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer travelId;
    @ApiModelProperty(value = "品家旅行内容")
    private String travelContent;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
