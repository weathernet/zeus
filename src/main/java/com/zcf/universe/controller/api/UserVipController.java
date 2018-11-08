package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.UserVip;
import com.zcf.universe.service.UserVipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@RestController
@Api(value = "用户会员控制器", tags = {"用户会员控制器"})
public class UserVipController {

    @Autowired
    private UserVipService userVipService;

    @ApiOperation(value = "新增")
    @PostMapping("userVip")
    public ResponseEntity<Void> addUserVip(UserVip userVip) {
        this.userVipService.addUserVip(userVip);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("userVip/{id}")
    public ResponseEntity<Void> deleteUserVip(@PathVariable Integer id) {
        this.userVipService.deleteUserVip(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("userVip")
    public ResponseEntity<Void> updateUserVip(UserVip userVip) {
        this.userVipService.updateUserVip(userVip);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("userVip/{id}")
    public ResponseEntity<UserVip> getUserVip(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userVipService.getUserVip(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("UserVip")
    public ResponseEntity<List<UserVip>> getAllUserVip() {
        return ResponseEntity.ok(this.userVipService.getAllUserVip());
    }
}
