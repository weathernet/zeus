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
@Table(name = "mall_group")
@ApiModel(value = "商城分类模型", description = "备注")
public class MallGroup{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer groupId;

    @ApiModelProperty(value = "名称")
    private String groupName;

    @ApiModelProperty(value = "图片")
    private String groupImage;

    @ApiModelProperty(value = "图标")
    private String group_icon;//分类小图片

    @ApiModelProperty(value = "热门")
    private String group_hot;//是否热门 0不热 1热

    @ApiModelProperty(value = "服务")
    private String group_by;//所属服务类型 0入住必备 1设备采购 2创业精选

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
