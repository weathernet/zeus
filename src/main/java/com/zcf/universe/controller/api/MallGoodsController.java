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
@Api(value = "商城商品控制器", tags = {"商城商品接口"})
public class MallGoodsController {

    @Autowired
    private MallGoodsService mallGoodsService;

    @ApiOperation(value = "获取分類下的所有商品")
    @GetMapping("MallGoods/{groupid}")
    public ResponseEntity<List<MallGoods>> getAllMallGoodsByGroupId(@PathVariable Integer groupid) {
        return ResponseEntity.ok(this.mallGoodsService.searchMallGoodsByGroupId(groupid));
    }

    @ApiOperation(value = "获取货物的具体信息")
    @GetMapping("mallGoods/{id}")
    public ResponseEntity<MallGoods> getMallGoods(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallGoodsService.getMallGoods(id));
    }

    @ApiOperation(value = "获取分類下的所有商品并排序")
    @GetMapping("MallGoodsSort")
    public ResponseEntity<List<MallGoods>> getAllMallGoodsByGroup(@RequestParam Integer groupid, Boolean sort) {
        return ResponseEntity.ok(this.mallGoodsService.getAllMallGoodsByGroup(groupid, sort));
    }

}
