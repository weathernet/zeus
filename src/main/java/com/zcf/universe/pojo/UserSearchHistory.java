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
@Table(name = "user_search_history")
@ApiModel(value = "UserSearchHistory模型", description = "UserSearchHistory信息")
public class UserSearchHistory{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer historyId;

    @ApiModelProperty(value = "用户Id")
    private Integer historyUserId;

    @ApiModelProperty(value = "搜索内容")
    private String historyContent;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
