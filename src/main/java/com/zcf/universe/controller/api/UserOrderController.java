package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.UserOrder;
import com.zcf.universe.service.UserOrderService;
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
@Api(value = "用户订单控制器", tags = {"用户订单控制器"})
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @ApiOperation(value = "新增")
    @PostMapping("userOrder")
    public ResponseEntity<Void> addUserOrder(UserOrder userOrder) {
        this.userOrderService.addUserOrder(userOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("userOrder/{id}")
    public ResponseEntity<Void> deleteUserOrder(@PathVariable Integer id) {
        this.userOrderService.deleteUserOrder(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("userOrder")
    public ResponseEntity<Void> updateUserOrder(UserOrder userOrder) {
        this.userOrderService.updateUserOrder(userOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("userOrder/{id}")
    public ResponseEntity<UserOrder> getUserOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userOrderService.getUserOrder(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("UserOrder")
    public ResponseEntity<List<UserOrder>> getAllUserOrder() {
        return ResponseEntity.ok(this.userOrderService.getAllUserOrder());
    }
}
