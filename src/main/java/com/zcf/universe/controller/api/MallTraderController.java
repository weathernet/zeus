package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MallTrader;
import com.zcf.universe.service.MallTraderService;
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
@Api(value = "商户管理控制器", tags = {"商户管理接口"})
public class MallTraderController {

    @Autowired
    private MallTraderService mallTraderService;

    @ApiOperation(value = "新增")
    @PostMapping("mallTrader")
    public ResponseEntity<Void> addMallTrader(MallTrader mallTrader) {
        this.mallTraderService.addMallTrader(mallTrader);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mallTrader/{id}")
    public ResponseEntity<Void> deleteMallTrader(@PathVariable Integer id) {
        this.mallTraderService.deleteMallTrader(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("mallTrader")
    public ResponseEntity<Void> updateMallTrader(MallTrader mallTrader) {
        this.mallTraderService.updateMallTrader(mallTrader);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("mallTrader/{id}")
    public ResponseEntity<MallTrader> getMallTrader(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallTraderService.getMallTrader(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MallTrader")
    public  ResponseEntity<List<MallTrader>> getAllMallTrader() {
       return ResponseEntity.ok(this.mallTraderService.getAllMallTrader());
    }
}
