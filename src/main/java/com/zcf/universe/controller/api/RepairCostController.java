package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.RepairCost;
import com.zcf.universe.service.RepairCostService;
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
@Api(value = "维修服务费用说明控制器", tags = {"维修服务费用说明接口"})
public class RepairCostController {

    @Autowired
    private RepairCostService repairCostService;

    @ApiOperation(value = "新增")
    @PostMapping("repairCost")
    public ResponseEntity<Void> addRepairCost(RepairCost repairCost) {
        this.repairCostService.addRepairCost(repairCost);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("repairCost/{id}")
    public ResponseEntity<Void> deleteRepairCost(@PathVariable Integer id) {
        this.repairCostService.deleteRepairCost(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("repairCost")
    public ResponseEntity<Void> updateRepairCost(RepairCost repairCost) {
        this.repairCostService.updateRepairCost(repairCost);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("repairCost/{id}")
    public ResponseEntity<RepairCost> getRepairCost(@PathVariable Integer id) {
        return ResponseEntity.ok(this.repairCostService.getRepairCost(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("RepairCost")
    public  ResponseEntity<List<RepairCost>> getAllRepairCost() {
       return ResponseEntity.ok(this.repairCostService.getAllRepairCost());
    }
}
