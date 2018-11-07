package com.zcf.universe.controller.api;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.pojo.UserInfo;
import com.zcf.universe.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * Created by YuanQJ on 2018/10/31.
 */
@RestController
@Api(value = "用户控制层", tags = {"用户操作接口"})
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoservice;

    @GetMapping("code")
    @ApiOperation(value = "获取验证码", notes = "手机号必填")
    @ApiImplicitParam(name = "phone", value = "用户的手机号", required = true, dataType = "String")
    public ResponseEntity<Void> getRegisterCode(String phone) {
        this.userInfoservice.getCode(phone);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("user")
    @ApiOperation(value = "用户注册", notes = "手机号不能为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> registerUser(UserInfo userInfo, @RequestParam("code") String code) {
        boolean b = this.userInfoservice.registerUser(userInfo, code);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("user")
    @ApiOperation(value = "用户手机号密码登录", notes = "手机号和密码不能为空")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "userPhoneNumber", value = "手机号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "userPassword", value = "密码", required = true, dataType = "String")
    })
    public ResponseEntity<UserInfo> loginUser(@RequestParam String userPhoneNumber, @RequestParam String userPassword) {
        UserInfo userInfo = this.userInfoservice.loginUser(userPhoneNumber, userPassword);
        return ResponseEntity.status(HttpStatus.OK).body(userInfo);
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "获取用户信息", notes = "ID一定不能为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable("id") Integer id) {
        UserInfo userInfo = this.userInfoservice.getUserInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(userInfo);

    }

    @PutMapping("user/{id}")
    @ApiOperation(value = "更新用户的信息", notes = "ID一定不能为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> updateUser(UserInfo user, @PathVariable("id") Integer id) {
        boolean flag = this.userInfoservice.updateUser(user, id);
        if (flag) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("userPortrait/{id}")
    @ApiOperation(value = "上传用户头像", notes = "图片不为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> upload(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath() + "static/";
        String customPath = "user/";//自定义图片存储路径
        String userHeadPortrait = FileUploadUtils.fileUpload(file, path, customPath);
        this.userInfoservice.uploadUserHeadPortrait(id, userHeadPortrait);
        return ResponseEntity.ok(null);
    }

    //Authentication
    @PostMapping("Authentication/{id}")
    @ApiOperation(value = "实名认证", notes = "图片不为空")
    @ApiImplicitParam(name = "id", value = "用户的主键", required = true, dataType = "int")
    public ResponseEntity<Void> authenticationUser(@PathVariable("id") Integer id, UserInfo info) {
        this.userInfoservice.updateUser(info, id);
        return ResponseEntity.ok(null);
    }

}
