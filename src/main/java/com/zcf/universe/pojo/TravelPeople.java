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
@Table(name = "travel_people")
@ApiModel(value = "订票人模型", description = "订票人信息")
public class TravelPeople{

    @Id
    @ApiModelProperty(value = "主键", required = true)
    private Integer peopleId;

    @ApiModelProperty(value = "主键用户")
    private Integer peopleUserId;

    @ApiModelProperty(value = "用户的姓名")
    private String peopleName;

    @ApiModelProperty(value = "手机号")
    private String peoplePhone;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
