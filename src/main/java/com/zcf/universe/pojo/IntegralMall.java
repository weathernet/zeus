package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
* @author YuanQJ
* @date 2018/12/18
*/
@Data
@Table(name = "integral_mall")
@ApiModel(value = "IntegralMall模型", description = "IntegralMall信息")
public class IntegralMall{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer integralId;

    @ApiModelProperty(value = "图片")
    private String integralImage;
    @ApiModelProperty(value = "b标题")
    private String integralTitle;
    @ApiModelProperty(value = "j价格")
    private String integralPrice;
    @ApiModelProperty(value = "s数量")
    private Integer integralNumber;

    @ApiModelProperty(value = "c创建时间")
    private Date cerateTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
