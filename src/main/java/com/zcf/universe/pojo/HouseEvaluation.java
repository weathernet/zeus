package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author YuanQJ
 * @date 2018/12/26
 */
@Data
@Table(name = "house_evaluation")
@ApiModel(value = "房源评价模型", description = "房源评价信息")
public class HouseEvaluation {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer id;
    @ApiModelProperty(value = "用户的主键")
    private Integer userId;
    @ApiModelProperty(value = "房屋主键")
    private Integer houseId;
    @ApiModelProperty(value = "用户的姓名")
    private String userName;
    @ApiModelProperty(value = "评价的内容")
    private String content;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
