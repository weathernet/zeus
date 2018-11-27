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
