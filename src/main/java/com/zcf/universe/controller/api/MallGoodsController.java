package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MallGoods;
import com.zcf.universe.service.MallGoodsService;
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
public class MallGoodsController {

    @Autowired
    private MallGoodsService mallGoodsService;

    @ApiOperation(value = "新增")
    @PostMapping("mallGoods")
    public ResponseEntity<Void> addMallGoods(MallGoods mallGoods) {
        this.mallGoodsService.addMallGoods(mallGoods);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mallGoods/{id}")
    public ResponseEntity<Void> deleteMallGoods(@PathVariable Integer id) {
        this.mallGoodsService.deleteMallGoods(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("mallGoods")
    public ResponseEntity<Void> updateMallGoods(MallGoods mallGoods) {
        this.mallGoodsService.updateMallGoods(mallGoods);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("mallGoods/{id}")
    public ResponseEntity<MallGoods> getMallGoods(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallGoodsService.getMallGoods(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MallGoods")
    public  ResponseEntity<List<MallGoods>> getAllMallGoods() {
       return ResponseEntity.ok(this.mallGoodsService.getAllMallGoods());
    }
}