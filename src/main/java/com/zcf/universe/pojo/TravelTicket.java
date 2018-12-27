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
@Table(name = "travel_ticket")
@ApiModel(value = "TravelTicket模型", description = "TravelTicket信息")
public class TravelTicket {
    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer ticketId;
    @ApiModelProperty(value = "景点的主键")
    private Integer ticketSceneryId;
    @ApiModelProperty(value = "门票标题")
    private String ticketTitle;
    @ApiModelProperty(value = "门票价格")
    private String ticketPrice;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
