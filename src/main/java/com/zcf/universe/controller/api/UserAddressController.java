package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.UserAddress;
import com.zcf.universe.service.UserAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/29.
 */
@RestController
@Api(value = "用户收货地址控制器", tags = {"用户收货地址接口"})
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @ApiOperation(value = "新增收货地址")
    @PostMapping("userAddress")
    public ResponseEntity addUserAddress(UserAddress userAddress) {
        this.userAddressService.addUserAddress(userAddress);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除用户地址")
    @DeleteMapping("userAddress/{id}")
    public ResponseEntity<Void> deleteUserAddress(@PathVariable Integer id) {
        this.userAddressService.deleteUserAddress(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改用户地址")
    @PutMapping("userAddress")
    public ResponseEntity updateUserAddress(UserAddress userAddress) {
        this.userAddressService.updateUserAddress(userAddress);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "获取用户默认地址")
    @GetMapping("userAddress/{id}")
    public ResponseEntity<UserAddress> getUserAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userAddressService.getUserAddress(id));
    }

    @ApiOperation(value = "获取当前用户所有的地址")
    @GetMapping("getUserAddress/{id}")
    public ResponseEntity<List<UserAddress>> getAllUserAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userAddressService.getAllUserAddress(id));
    }

    @ApiOperation(value = "选择收货地址")
    @GetMapping("selectUserAddress")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "addressId", value = "地址的主键", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userId", value = "用户的主键", required = true, dataType = "Integer")

    })
    public ResponseEntity<UserAddress> selectUserAddress(
            @RequestParam("addressId") Integer addressId,
            @RequestParam("userId") Integer userId
    ) {
        return ResponseEntity.ok(this.userAddressService.selectUserAddress(addressId, userId));
    }
}
