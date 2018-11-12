package com.zcf.universe.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Table(name = "user_info")
@ApiModel(value = "用户信息模型", description = "用户对象user")
public class UserInfo {
    @Id
    @ApiModelProperty(value = "用户ID,主键", required = true)
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "真实姓名", required = true)
    @Column(name = "user_real_name")
    private String userRealName;

    @ApiModelProperty(value = "用户昵称")
    @Column(name = "user_nike_name")
    @NotBlank(message = "用户名不能为空")
    private String userNikeName;

    @ApiModelProperty(value = "用户密码", required = true)
    @Column(name = "user_password")
    private String userPassword;

    @ApiModelProperty(value = "身份证号码")
    @Column(name = "user_identification")
    private String userIdentification;

    @ApiModelProperty(value = "用户性别:0女 1男", required = true)
    @Column(name = "user_gender")
    private Integer userGender;

    @ApiModelProperty(value = "头像")
    @Column(name = "user_head_portrait")
    private String userHeadPortrait;

    @ApiModelProperty(value = "手机号", required = true)
    @Column(name = "user_phone_number")
    private String userPhoneNumber;


    @ApiModelProperty(value = "用户的邮箱")
    @Column(name = "user_email")
    @Email(message = "请输入正确的邮箱格式")
    private String userEmail;

    @ApiModelProperty(value = "微信开放平台")
    @Column(name = "user_we_chat_openid")
    private String userWeChatOpenid;

    @ApiModelProperty(value = "支付宝开放平台")
    @Column(name = "user_ali_pay_openid")
    private String userAliPayOpenid;

    @ApiModelProperty(value = "芝麻信用分")
    @Column(name = "user_sesame_score")
    private String userSesameScore;

    @ApiModelProperty(value = "用户的钱包")
    @Column(name = "user_wallet")
    private String userWallet;

    @ApiModelProperty(value = "用户实名认证状态：0未认证 1已认证2.审核中")
    @Column(name = "user_state")
    private Integer userState;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}