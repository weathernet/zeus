package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MoveOrder;
import com.zcf.universe.service.MoveOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/15.
 */
@RestController
@Api(value = "搬家订单管理控制器", tags = {"搬家订单管理接口"})
public class MoveOrderController {

    @Autowired
    private MoveOrderService moveOrderService;

    @ApiOperation(value = "增加搬家的订单")
    @PostMapping("moveOrder")
    public ResponseEntity<Void> addMoveOrder(MoveOrder moveOrder) {
        this.moveOrderService.addMoveOrder(moveOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取搬家订单的详细信息")
    @GetMapping("moveOrder/{id}")
    public ResponseEntity<MoveOrder> getMoveOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(this.moveOrderService.getMoveOrder(id));
    }

    @ApiOperation(value = "获取用户所有的搬家订单")
    @GetMapping("moveOrder")
    public ResponseEntity<List<MoveOrder>> getMoveOrderByUser(@RequestParam Integer userId) {
        return ResponseEntity.ok(this.moveOrderService.getMoveOrderByUser(userId));
    }
}
