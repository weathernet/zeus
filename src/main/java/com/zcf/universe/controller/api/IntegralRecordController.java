package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.IntegralRecord;
import com.zcf.universe.service.IntegralRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @author YuanQJ
* @date 2018/12/18
*/
@RestController
@Api(value = "积分记录控制器", tags = {"积分记录接口"})
public class IntegralRecordController {

    @Autowired
    private IntegralRecordService integralRecordService;

    @ApiOperation(value = "新增")
    @PostMapping("integralRecord")
    public ResponseEntity<Void> addIntegralRecord(IntegralRecord integralRecord) {
        this.integralRecordService.addIntegralRecord(integralRecord);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("integralRecord/{id}")
    public ResponseEntity<Void> deleteIntegralRecordById(@PathVariable Integer id) {
        this.integralRecordService.deleteIntegralRecordById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改")
    @PutMapping("integralRecord")
    public ResponseEntity<Void> updateIntegralRecord(IntegralRecord integralRecord) {
        this.integralRecordService.updateIntegralRecord(integralRecord);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("integralRecord/{id}")
    public ResponseEntity<IntegralRecord> getIntegralRecord(@PathVariable Integer id) {
        return ResponseEntity.ok(this.integralRecordService.getIntegralRecord(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("IntegralRecord")
    public  ResponseEntity<List<IntegralRecord>> getAllIntegralRecord() {
       return ResponseEntity.ok(this.integralRecordService.getAllIntegralRecord());
    }
}
