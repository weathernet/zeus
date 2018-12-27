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
@Table(name = "owner_quotation")
@ApiModel(value = "OwnerQuotation模型", description = "OwnerQuotation信息")
public class OwnerQuotation {

    @Id
    @ApiModelProperty(value = "主键", required = true,position = 1)
    private Integer id;
    @ApiModelProperty(value = "一月",position = 2)
    private String january;
    @ApiModelProperty(value = "二月",position = 3)
    private String february;
    @ApiModelProperty(value = "三月",position = 4)
    private String march;
    @ApiModelProperty(value = "四月",position = 5)
    private String april;
    @ApiModelProperty(value = "五月",position = 6)
    private String may;
    @ApiModelProperty(value = "六月",position = 7)
    private String june;
    @ApiModelProperty(value = "七月",position = 8)
    private String july;
    @ApiModelProperty(value = "八月",position = 9)
    private String august;
    @ApiModelProperty(value = "九月",position = 10)
    private String september;
    @ApiModelProperty(value = "十月",position = 11)
    private String october;
    @ApiModelProperty(value = "十一月",position = 12)
    private String november;
    @ApiModelProperty(value = "十二月",position =13)
    private String december;
    @ApiModelProperty(value = "城市名",position = 14)
    private String city;
    @ApiModelProperty(value = "戶室",position = 15)
    private String type;
    @ApiModelProperty(value = "创建时间",position = 16)
    private Date createTime;
    @ApiModelProperty(value = "更新时间",position = 17)
    private Date updateTime;

}
