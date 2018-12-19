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
@Api(value = "商品控制器", tags = {"商品接口"})
public class MallGoodsController {

    @Autowired
    private MallGoodsService mallGoodsService;

    @ApiOperation(value = "根据分类获取所有商品")
    @GetMapping("MallGoods/{groupid}")
    public  ResponseEntity<List<MallGoods>> getAllMallGoodsByGroupId(@PathVariable Integer groupid) {
        return ResponseEntity.ok(this.mallGoodsService.searchMallGoodsByGroupId(groupid));
    }


    @ApiOperation(value = "商家端新增商品")
    @PostMapping("mallGoods")
    public ResponseEntity<Void> addMallGoods(@RequestBody MallGoods mallGoods) {
        this.mallGoodsService.addMallGoods(mallGoods);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "商家端删除商品")
    @DeleteMapping("mallGoods/{id}")
    public ResponseEntity<Void> deleteMallGoods(@PathVariable Integer id) {
        this.mallGoodsService.deleteMallGoods(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "商家端修改商品的信息")
    @PutMapping("mallGoods")
    public ResponseEntity<Void> updateMallGoods(MallGoods mallGoods) {
        this.mallGoodsService.updateMallGoods(mallGoods);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取货物的具体信息")
    @GetMapping("mallGoods/{id}")
    public ResponseEntity<MallGoods> getMallGoods(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallGoodsService.getMallGoods(id));
    }

}
