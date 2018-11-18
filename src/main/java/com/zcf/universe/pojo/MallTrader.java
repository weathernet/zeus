package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Created by YuanQJ on 2018/11/18.
 */
@Data
@Table(name = "mall_trader")
@ApiModel(value = "MallTrader模型", description = "备注")
public class MallTrader{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer traderId;

    @ApiModelProperty(value = "商户名称")
    private String traderName;

    @ApiModelProperty(value = "商户密码")
    private String traderPassword;

    @ApiModelProperty(value = "商户编号")
    private String traderImage;

}
