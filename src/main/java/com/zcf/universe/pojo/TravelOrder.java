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
@Table(name = "travel_order")
@ApiModel(value = "TravelOrder模型", description = "TravelOrder信息")
public class TravelOrder{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer orderId;

    @ApiModelProperty(value = "用户主键")
    private Integer orderUserId;

    @ApiModelProperty(value = "旅游的人")
    private Integer orderPeopleId;

    @ApiModelProperty(value = "门票数量")
    private Integer orderNumber;

    @ApiModelProperty(value = "总价")
    private String orderSumPrice;

    @ApiModelProperty(value = "门票标题")
    private String orderTitle;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
