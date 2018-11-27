package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.TravelOrder;
import com.zcf.universe.service.TravelOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
* Created by YuanQJ on 2018/11/19.
*/
@RestController
@Api(value = "旅游购票订单管理控制器", tags = {"旅游购票订单管理接口"})
public class TravelOrderController {

    @Autowired
    private TravelOrderService travelOrderService;


    @ApiOperation(value = "预约购票订单")
    @PostMapping("crt_travelorder")
    public ResponseEntity<Void> addOrder(TravelOrder travelOrder) {
        this.travelOrderService.addOrder(travelOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "用户获取购票订单")
    @PostMapping("sel_travelorder")
    public ResponseEntity<List<TravelOrder>> getOrder(String userid) {
        return ResponseEntity.ok(this.travelOrderService.searchTravelOrder(userid));
    }

    //使用订单
    @ApiOperation(value = "使用订单")
    @PutMapping("use_travelorder")
    public ResponseEntity<Void> useTravelOrder(String orderid) {
        this.travelOrderService.useTravelOrder(orderid);
        return ResponseEntity.ok(null);
    }

    //订单过期
    @ApiOperation(value = "订单过期")
    @PutMapping("over_travelorder")
    public ResponseEntity<Void> overTravelOrder(String orderid) {
        this.travelOrderService.overTravelOrder(orderid);
        return ResponseEntity.ok(null);
    }

    //取消订单
    @ApiOperation(value = "取消订单")
    @DeleteMapping("cancel_travelorder")
    public ResponseEntity<Void> cancelTravelOrder(String orderid) {
        this.travelOrderService.cancelTravelOrder(Integer.parseInt(orderid));
        return ResponseEntity.ok(null);
    }


    /*****************************************************************************/


    @ApiOperation(value = "新增")
    @PostMapping("travelOrder")
    public ResponseEntity<Void> addTravelOrder(TravelOrder travelOrder) {
        this.travelOrderService.addTravelOrder(travelOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("travelOrder/{id}")
    public ResponseEntity<Void> deleteTravelOrder(@PathVariable Integer id) {
        this.travelOrderService.deleteTravelOrder(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("travelOrder")
    public ResponseEntity<Void> updateTravelOrder(TravelOrder travelOrder) {
        this.travelOrderService.updateTravelOrder(travelOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("travelOrder/{id}")
    public ResponseEntity<TravelOrder> getTravelOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(this.travelOrderService.getTravelOrder(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("TravelOrder")
    public  ResponseEntity<List<TravelOrder>> getAllTravelOrder() {
       return ResponseEntity.ok(this.travelOrderService.getAllTravelOrder());
    }
}
