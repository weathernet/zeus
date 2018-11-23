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
@Table(name = "travel_scenery")
@ApiModel(value = "TravelScenery模型", description = "TravelScenery信息")
public class TravelScenery{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer sceneryId;

    @ApiModelProperty(value = "景点标题")
    private String sceneryTitle;

    @ApiModelProperty(value = "副标题")
    private String scenerySbuTitle;

    @ApiModelProperty(value = "景点图片")
    private String sceneryImage;

    @ApiModelProperty(value = "风景分组")
    private Integer sceneryGroup;

    @ApiModelProperty(value = "景点价格")
    private String sceneryPrice;

    @ApiModelProperty(value = "城市")
    private String sceneryCity;

    @ApiModelProperty(value = "景点地址")
    private String sceneryAddress;

    @ApiModelProperty(value = "访问量")
    private Integer sceneryNumber;

    @ApiModelProperty(value = "景点评分")
    private String sceneryPoint;//景点评分

    @ApiModelProperty(value = "景点备注")
    private String sceneryRemark;//景点备注

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
