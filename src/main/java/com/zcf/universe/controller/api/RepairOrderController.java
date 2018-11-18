package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.RepairOrder;
import com.zcf.universe.service.RepairOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/13.
*/
@RestController
@Api(value = "维修订单控制器", tags = {"维修订单接口"})
public class RepairOrderController {

    @Autowired
    private RepairOrderService repairOrderService;

    @ApiOperation(value = "新增")
    @PostMapping("repairOrder")
    public ResponseEntity<Void> addRepairOrder(RepairOrder repairOrder) {
        this.repairOrderService.addRepairOrder(repairOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("repairOrder/{id}")
    public ResponseEntity<Void> deleteRepairOrder(@PathVariable Integer id) {
        this.repairOrderService.deleteRepairOrder(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("repairOrder")
    public ResponseEntity<Void> updateRepairOrder(RepairOrder repairOrder) {
        this.repairOrderService.updateRepairOrder(repairOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("repairOrder/{id}")
    public ResponseEntity<RepairOrder> getRepairOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(this.repairOrderService.getRepairOrder(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("RepairOrder")
    public  ResponseEntity<List<RepairOrder>> getAllRepairOrder() {
       return ResponseEntity.ok(this.repairOrderService.getAllRepairOrder());
    }
}
