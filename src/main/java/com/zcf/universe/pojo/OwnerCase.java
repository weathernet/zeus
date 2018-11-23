package com.zcf.universe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * Created by YuanQJ on 2018/11/22.
 */
@Data
@Table(name = "owner_case")
@ApiModel(value = "OwnerCase模型", description = "OwnerCase信息")
public class OwnerCase{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer caseId;

    @ApiModelProperty(value = "标题")
    private String caseTitle;

    @ApiModelProperty(value = "副标题")
    private String caseSubTitle;

    @ApiModelProperty(value = "图片")
    private String caseImage;

    @ApiModelProperty(value = "内容")
    private String caseContent;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
