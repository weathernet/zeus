package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.UserInfo;
import com.zcf.universe.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by YuanQJ on 2018/10/31.
 */
@CrossOrigin
@RestController
@Api(value = "用户控制器", tags = {"用户控制器"})
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoservice;

    @GetMapping("registerCode")
    @ApiOperation(value = "获取注册时的验证码", notes = "手机号必填")
    @ApiImplicitParam(name = "phone", value = "用户的手机号", required = true, dataType = "String")
    public ResponseEntity<Void> getRegisterCode(String phone) {
        this.userInfoservice.getRegisterCode(phone);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("forgetCode")
    @ApiOperation(value = "获取忘记密码时的验证码", notes = "手机号必填")
    @ApiImplicitParam(name = "phone", value = "用户的手机号", required = true, dataType = "String")
    public ResponseEntity<Void> getForgetCode(String phone) {
        this.userInfoservice.getForgetCode(phone);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("password")
    @ApiOperation(value = "修改用户密码", notes = "手机号,密码必填")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "phone", value = "用户的手机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "新密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "forgetCode", value = "验证码", required = true, dataType = "String")
    })
    public ResponseEntity<Void> updateUserPassword(
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            @RequestParam("forgetCode") String forgetCode
    ) {
        this.userInfoservice.updateUSerPasswords(phone, password, forgetCode);
        return ResponseEntity.ok().build();
    }

    @PostMapping("user")
    @ApiOperation(value = "用户注册", notes = "手机号不能为空")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userPhoneNumber", value = "用户的手机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "registerCode", value = "验证码", required = true, dataType = "String")
    })
    public ResponseEntity<Void> registerUser(
            @RequestParam("userPhoneNumber") String userPhoneNumber,
            @RequestParam("userPassword") String userPassword,
            @RequestParam("registerCode") String registerCode
    ) {
        this.userInfoservice.registerUser(userPhoneNumber, userPassword, registerCode);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "user")
    @ApiOperation(value = "用户手机号密码登录", notes = "手机号和密码不能为空")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userPhoneNumber", value = "手机号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "userPassword", value = "密码", required = true, dataType = "String")
    })
    public ResponseEntity<UserInfo> loginUser(@RequestParam String userPhoneNumber, @RequestParam String userPassword) {
        return ResponseEntity.ok(this.userInfoservice.loginUser(userPhoneNumber, userPassword));
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "获取用户信息", notes = "ID一定不能为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userInfoservice.getUserInfo(id));

    }

    @PutMapping("user/{id}")
    @ApiOperation(value = "更新用户的信息", notes = "ID一定不能为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> updateUser(UserInfo user, @PathVariable("id") Integer id) {
        this.userInfoservice.updateUser(user, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

/*    @PostMapping("userPortrait/{id}")
    @ApiOperation(value = "上传用户头像", notes = "图片不为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> upload(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
        this.userInfoservice.uploadUserHeadPortrait(id, file);
        return ResponseEntity.ok().build();
    }*/

    @PostMapping("Authentication/{id}")
    @ApiOperation(value = "实名认证")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> authenticationUser(@PathVariable("id") Integer id, UserInfo info) {
        this.userInfoservice.AuthenticationUser(info, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("Authentication/{id}")
    @ApiOperation(value = "查看该用户是否已经实名")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Boolean> isAuthentication(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userInfoservice.isAuthentication(id));
    }

    @GetMapping("loginByWeChatAndAliPay")
    @ApiOperation(value = "微信和支付宝登录")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Openid", value = "OpenId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "微信0,支付宝1", required = true, dataType = "int")
    })
    public ResponseEntity<UserInfo> loginByWeChatAndAliPay(@RequestParam String Openid, @RequestParam int type) {
        return ResponseEntity.ok(this.userInfoservice.loginByWeChatAndAliPay(Openid, type));
    }

    @PutMapping("bandWeChatAndAliPayByPhone")
    @ApiOperation(value = "绑定手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhoneNumber", value = "用户的手机号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "weChatAndAliPayId", value = "开放平台的OpenId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "registerCode", value = "验证码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "微信0，支付宝1", required = true, dataType = "int")
    })
    public ResponseEntity<Void> bandWeChatAndAliPay(
            @RequestParam(value = "userPhoneNumber", required = false) String userPhoneNumber,
            @RequestParam(value = "userPassword", required = false) String userPassword,
            @RequestParam(value = "registerCode", required = false) String registerCode,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "weChatAndAliPayId", required = false) String weChatAndAliPayId
    ) {
        this.userInfoservice.bandWeChatAndAliPay(weChatAndAliPayId, userPhoneNumber, userPassword, type, registerCode);
        return ResponseEntity.ok().build();
    }

    @PutMapping("passWord/{id}")
    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户主键", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "oldPassWord", value = "旧用户密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newPassWord", value = "验证码", required = true, dataType = "String"),

    })
    public ResponseEntity changePassWord(
            @PathVariable("id") Integer id,
            @RequestParam("oldPassWord") String oldPassWord,
            @RequestParam("newPassWord") String newPassWord
    ) {
        this.userInfoservice.changePassWord(id, oldPassWord, newPassWord);
        return ResponseEntity.ok().build();
    }

    @PutMapping("userPhoneNumber/{id}")
    @ApiOperation(value = "修改绑定手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户主键", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userPhone", value = "用户手机号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "changeCode", value = "验证码", required = true, dataType = "String"),

    })
    public ResponseEntity changeUserPhoneNumber(
            @PathVariable("id") Integer id,
            @RequestParam("userPhoneNumber") String userPhoneNumber,
            @RequestParam("changeCode") String changeCode
    ) {
        this.userInfoservice.changeUserPhoneNumber(id, userPhoneNumber, changeCode);
        return ResponseEntity.ok().build();
    }
}
