package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.MallEvaluate;
import com.zcf.universe.service.MallEvaluateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

/**
* Created by YuanQJ on 2018/11/18.
*/
@RestController
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class MallEvaluateController {

    @Autowired
    private MallEvaluateService mallEvaluateService;

    @ApiOperation(value = "新增")
    @PostMapping("mallEvaluate")
    public ResponseEntity<Void> addMallEvaluate(MallEvaluate mallEvaluate) {
        this.mallEvaluateService.addMallEvaluate(mallEvaluate);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mallEvaluate/{id}")
    public ResponseEntity<Void> deleteMallEvaluate(@PathVariable Integer id) {
        this.mallEvaluateService.deleteMallEvaluate(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("mallEvaluate")
    public ResponseEntity<Void> updateMallEvaluate(MallEvaluate mallEvaluate) {
        this.mallEvaluateService.updateMallEvaluate(mallEvaluate);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("mallEvaluate/{id}")
    public ResponseEntity<MallEvaluate> getMallEvaluate(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallEvaluateService.getMallEvaluate(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MallEvaluate")
    public  ResponseEntity<List<MallEvaluate>> getAllMallEvaluate() {
       return ResponseEntity.ok(this.mallEvaluateService.getAllMallEvaluate());
    }
}
