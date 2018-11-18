package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MallRecord;
import com.zcf.universe.service.MallRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/18.
*/
@RestController
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class MallRecordController {

    @Autowired
    private MallRecordService mallRecordService;

    @ApiOperation(value = "新增")
    @PostMapping("mallRecord")
    public ResponseEntity<Void> addMallRecord(MallRecord mallRecord) {
        this.mallRecordService.addMallRecord(mallRecord);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mallRecord/{id}")
    public ResponseEntity<Void> deleteMallRecord(@PathVariable Integer id) {
        this.mallRecordService.deleteMallRecord(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("mallRecord")
    public ResponseEntity<Void> updateMallRecord(MallRecord mallRecord) {
        this.mallRecordService.updateMallRecord(mallRecord);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("mallRecord/{id}")
    public ResponseEntity<MallRecord> getMallRecord(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallRecordService.getMallRecord(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MallRecord")
    public  ResponseEntity<List<MallRecord>> getAllMallRecord() {
       return ResponseEntity.ok(this.mallRecordService.getAllMallRecord());
    }
}
