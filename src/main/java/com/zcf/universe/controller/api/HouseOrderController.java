package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.HouseOrder;
import com.zcf.universe.service.HouseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/27
 */
@RestController
@Api(value = "房源订单控制器", tags = {"房源订单接口"})
public class HouseOrderController {

    @Autowired
    private HouseOrderService houseOrderService;

    @ApiOperation(value = "新增用户房源的订单")
    @PostMapping("houseOrder")
    public ResponseEntity<Void> addHouseOrder(HouseOrder houseOrder) {
        this.houseOrderService.addHouseOrder(houseOrder);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "获取用户所有的租房订单")
    @GetMapping("HouseOrder")
    public ResponseEntity<List<HouseOrder>> getAllHouseOrder(@RequestParam Integer userId) {
        return ResponseEntity.ok(this.houseOrderService.getAllHouseOrder(userId));
    }
}
