package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.RepairDetails;
import com.zcf.universe.service.RepairDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/13.
*/
@RestController
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class RepairDetailsController {

    @Autowired
    private RepairDetailsService repairDetailsService;

    @ApiOperation(value = "新增")
    @PostMapping("repairDetails")
    public ResponseEntity<Void> addRepairDetails(RepairDetails repairDetails) {
        this.repairDetailsService.addRepairDetails(repairDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("repairDetails/{id}")
    public ResponseEntity<Void> deleteRepairDetails(@PathVariable Integer id) {
        this.repairDetailsService.deleteRepairDetails(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("repairDetails")
    public ResponseEntity<Void> updateRepairDetails(RepairDetails repairDetails) {
        this.repairDetailsService.updateRepairDetails(repairDetails);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("repairDetails/{id}")
    public ResponseEntity<RepairDetails> getRepairDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(this.repairDetailsService.getRepairDetails(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("RepairDetails")
    public  ResponseEntity<List<RepairDetails>> getAllRepairDetails() {
       return ResponseEntity.ok(this.repairDetailsService.getAllRepairDetails());
    }
}
