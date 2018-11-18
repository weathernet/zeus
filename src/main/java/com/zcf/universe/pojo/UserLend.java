package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "user_lend")
@ApiModel(value = "免息借款模型", description = "备注")
public class UserLend {

    @ApiModelProperty(value = "借款ID")
    @Column(name = "lend_id")
    private Integer lendId;

    @ApiModelProperty(value = "借款ID")
    @Column(name = "lend_user_id")
    private Integer lendUserId;

    @ApiModelProperty(value = "真实姓名")
    @Column(name = "lend_user_name")
    private String lendUserName;

    @ApiModelProperty(value = "借款金额")
    @Column(name = "lend_price")
    private String lendPrice;

    @ApiModelProperty(value = "借款状态:0待审核1.已通过2.未通过")
    @Column(name = "lend_status")
    private Integer lendStatus;

}