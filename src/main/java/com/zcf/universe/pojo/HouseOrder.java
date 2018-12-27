package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
* @author YuanQJ
* @date 2018/12/27
*/
@Data
@Table(name = "house_order")
@ApiModel(value = "租房订单模型", description = "租房订单信息")
public class HouseOrder {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer id;
    @ApiModelProperty(value = "用戶的主鍵")
    private Integer userId;
    @ApiModelProperty(value = "房源的主鍵")
    private Integer houseId;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "每月应还金额")
    private String monthlyPrice;
    @ApiModelProperty(value = "一共住多长时间")
    private Integer howLong;
    @ApiModelProperty(value = "剩余多长时间")
    private Integer surplus;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
