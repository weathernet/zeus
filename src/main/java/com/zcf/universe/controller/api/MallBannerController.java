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
@CrossOrigin
@RestController
@Api(value = "商城轮播图控制器", tags = {"商城轮播图接口"})
public class MallBannerController {

    @Autowired
    private MallBannerService mallBannerService;


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
