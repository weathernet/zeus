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
@Table(name = "owner_news")
@ApiModel(value = "新闻模型", description = "新闻信息")
public class OwnerNews{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer newsId;

    @ApiModelProperty(value = "新闻图片")
    private String newsImage;

    @ApiModelProperty(value = "新闻标题")
    private String newsTitle;

    @ApiModelProperty(value = "跳转地址")
    private String newsUrl;

    @ApiModelProperty(value = "新闻的内容")
    private String newsContent;

    @ApiModelProperty(value = "是否跳转外部0.是1.否")
    private Integer newsType;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
