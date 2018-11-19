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
@Table(name = "travel_group")
@ApiModel(value = "TravelGroup模型", description = "TravelGroup信息")
public class TravelGroup{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer groupId;

    @ApiModelProperty(value = "分类名称")
    private String groupName;

    @ApiModelProperty(value = "分类图标")
    private String groupIcon;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
