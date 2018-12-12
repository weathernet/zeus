package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.HomeRecommend;
import com.zcf.universe.service.HomeRecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@RestController
@Api(value = "首页推荐控制器", tags = {"首页推荐控制器"})
public class HomeRecommendController {

    @Autowired
    private HomeRecommendService homeRecommendService;

    @ApiOperation(value = "获取单个推荐")
    @GetMapping("homeRecommend/{id}")
    public ResponseEntity<HomeRecommend> getHomeRecommend(@PathVariable Integer id) {
        return ResponseEntity.ok(this.homeRecommendService.getHomeRecommend(id));
    }

    @ApiOperation(value = "获取分类后的推荐")
    @GetMapping("homeRecommendStatus")
    public ResponseEntity<List<HomeRecommend>> getHomeRecommendType(@RequestParam Integer type) {
        return ResponseEntity.ok(this.homeRecommendService.getHomeRecommendType(type));
    }

}
