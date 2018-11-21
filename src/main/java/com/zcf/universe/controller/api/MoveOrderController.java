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
@Api(value = "订单管理控制器", tags = {"订单管理接口"})
public class MoveOrderController {

    @Autowired
    private MoveOrderService moveOrderService;

    @ApiOperation(value = "新增")
    @PostMapping("moveOrder")
    public ResponseEntity<Void> addMoveOrder(MoveOrder moveOrder) {
        this.moveOrderService.addMoveOrder(moveOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("moveOrder/{id}")
    public ResponseEntity<Void> deleteMoveOrder(@PathVariable Integer id) {
        this.moveOrderService.deleteMoveOrder(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("moveOrder")
    public ResponseEntity<Void> updateMoveOrder(MoveOrder moveOrder) {
        this.moveOrderService.updateMoveOrder(moveOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("moveOrder/{id}")
    public ResponseEntity<MoveOrder> getMoveOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(this.moveOrderService.getMoveOrder(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MoveOrder")
    public  ResponseEntity<List<MoveOrder>> getAllMoveOrder() {
       return ResponseEntity.ok(this.moveOrderService.getAllMoveOrder());
    }
}
