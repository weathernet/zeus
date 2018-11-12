package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "home_story")
@ApiModel(value = "首页故事模型", description = "故事信息")
public class HomeStory {

    @Id
    @Column(name = "story_id")
    @ApiModelProperty(value = "主键")
    private Integer storyId;

    @ApiModelProperty(value = "故事标题")
    @Column(name = "story_title")
    private String storyTitle;

    @ApiModelProperty(value = "故事的内容")
    @Column(name = "story_content")
    private String storyContent;

    @ApiModelProperty(value = "故事图片")
    @Column(name = "story_image")
    private String storyImage;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}