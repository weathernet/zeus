package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MallBanner;
import com.zcf.universe.service.MallBannerService;
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
@Api(value = "商城轮播图", tags = {"商城轮播图接口"})
public class MallBannerController {

    @Autowired
    private MallBannerService mallBannerService;

    @ApiOperation(value = "新增")
    @PostMapping("mallBanner")
    public ResponseEntity<Void> addMallBanner(MallBanner mallBanner) {
        this.mallBannerService.addMallBanner(mallBanner);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mallBanner/{id}")
    public ResponseEntity<Void> deleteMallBanner(@PathVariable Integer id) {
        this.mallBannerService.deleteMallBanner(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("mallBanner")
    public ResponseEntity<Void> updateMallBanner(MallBanner mallBanner) {
        this.mallBannerService.updateMallBanner(mallBanner);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("mallBanner/{id}")
    public ResponseEntity<MallBanner> getMallBanner(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallBannerService.getMallBanner(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MallBanner")
    public  ResponseEntity<List<MallBanner>> getAllMallBanner() {
       return ResponseEntity.ok(this.mallBannerService.getAllMallBanner());
    }
}
