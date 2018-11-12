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

import java.io.FileNotFoundException;

/**
 * Created by YuanQJ on 2018/10/31.
 */
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
            @ApiImplicitParam(name = "password", value = "新密码", required = true, dataType = "String")
    })
    public ResponseEntity<Void> updateUserPassword(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        this.userInfoservice.updateUSerPasswords(phone, password);
        return ResponseEntity.ok().build();
    }

    @PostMapping("user")
    @ApiOperation(value = "用户注册", notes = "手机号不能为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> registerUser(UserInfo userInfo, @RequestParam("code") String code) {
        this.userInfoservice.registerUser(userInfo, code);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("user")
    @ApiOperation(value = "用户手机号密码登录", notes = "手机号和密码不能为空")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userPhoneNumber", value = "手机号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "userPassword", value = "密码", required = true, dataType = "String")
    })
    public ResponseEntity<UserInfo> loginUser(@RequestParam String userPhoneNumber, @RequestParam String userPassword) {
        UserInfo userInfo = this.userInfoservice.loginUser(userPhoneNumber, userPassword);
        return ResponseEntity.ok(userInfo);
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

    @PostMapping("userPortrait/{id}")
    @ApiOperation(value = "上传用户头像", notes = "图片不为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> upload(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
        this.userInfoservice.uploadUserHeadPortrait(id, file);
        return ResponseEntity.ok().build();
    }

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

}
