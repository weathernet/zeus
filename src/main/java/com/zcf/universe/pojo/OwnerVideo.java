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
@Table(name = "owner_video")
@ApiModel(value = "视频模型", description = "视频信息")
public class OwnerVideo {

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer videoId;
    @ApiModelProperty(value = "视频封面")
    private String videoImage;
    @ApiModelProperty(value = "视频地址")
    private String videoContent;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
