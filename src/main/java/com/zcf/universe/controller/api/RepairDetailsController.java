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
@Api(value = "维修详情控制器", tags = {"维修详情接口"})
public class RepairDetailsController {

    @Autowired
    private RepairDetailsService repairDetailsService;


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
