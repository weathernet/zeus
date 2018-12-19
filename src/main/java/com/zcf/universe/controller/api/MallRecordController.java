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
@Api(value = "商城记录控制器", tags = {"商城记录接口"})
public class MallRecordController {

    @Autowired
    private MallRecordService mallRecordService;

    @ApiOperation(value = "新增")
    @PostMapping("mallRecord")
    public ResponseEntity<Void> addMallRecord(MallRecord mallRecord) {
        this.mallRecordService.addMallRecord(mallRecord);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取当前用户的消费记录")
    @GetMapping("MallRecord")
    public ResponseEntity<List<MallRecord>> getAllMallRecord(@RequestParam Integer userId) {
        return ResponseEntity.ok(this.mallRecordService.getAllMallRecord(userId));
    }
}
