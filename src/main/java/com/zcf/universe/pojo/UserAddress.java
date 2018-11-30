package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by YuanQJ on 2018/11/29.
 */
@Data
@Table(name = "user_address")
@ApiModel(value = "UserAddress模型", description = "UserAddress信息")
public class UserAddress {

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer addressId;

    @ApiModelProperty(value = "用户Id")
    private Integer addressUserId;

    @ApiModelProperty(value = "收货人姓名")
    private String addressName;

    @ApiModelProperty(value = "收货人手机号")
    private String addressPhone;

    @ApiModelProperty(value = "收货地址")
    private String addressReceiving;

    @ApiModelProperty(value = "是否默认0.不默认1.默认")
    private Integer addressDefault;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
