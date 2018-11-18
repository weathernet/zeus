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
@Table(name = "mall_evaluate")
@ApiModel(value = "MallEvaluate模型", description = "备注")
public class MallEvaluate{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer evaluateId;

    @ApiModelProperty(value = "商户主键")
    private Integer evaluateTraderId;

    @ApiModelProperty(value = "商品的主键")
    private Integer evaluateGoodsId;

    @ApiModelProperty(value = "用户ID")
    private Integer evaluateUserId;

    @ApiModelProperty(value = "用户昵称")
    private String evaluateUserNickName;

    @ApiModelProperty(value = "照片")
    private String evaluateImage;

    @ApiModelProperty(value = "评价的内容")
    private String evaluateContent;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
