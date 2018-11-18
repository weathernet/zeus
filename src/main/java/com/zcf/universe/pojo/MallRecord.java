package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * Created by YuanQJ on 2018/11/18.
 */
@Data
@Table(name = "mall_record")
@ApiModel(value = "商城备注模型", description = "备注")
public class MallRecord{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer recordId;

    @ApiModelProperty(value = "用户编号")
    private Integer recordUserId;

    @ApiModelProperty(value = "支付方式")
    private String recordType;

    @ApiModelProperty(value = "消费节介绍")
    private String recordContent;

    @ApiModelProperty(value = "金额")
    private String recordPrice;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "跟新时间")
    private Date updateTime;

}
