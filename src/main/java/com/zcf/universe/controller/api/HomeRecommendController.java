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

    @ApiOperation(value = "新增")
    @PostMapping("homeRecommend")
    public ResponseEntity<Void> addHomeRecommend(HomeRecommend homeRecommend) {
        this.homeRecommendService.addHomeRecommend(homeRecommend);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("homeRecommend/{id}")
    public ResponseEntity<Void> deleteHomeRecommend(@PathVariable Integer id) {
        this.homeRecommendService.deleteHomeRecommend(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("homeRecommend")
    public ResponseEntity<Void> updateHomeRecommend(HomeRecommend homeRecommend) {
        this.homeRecommendService.updateHomeRecommend(homeRecommend);
        return ResponseEntity.ok(null);
    }

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

    @ApiOperation(value = "获取所有推荐")
    @GetMapping("homeRecommends")
    public ResponseEntity<List<HomeRecommend>> getAllHomeRecommend() {
        return ResponseEntity.ok(this.homeRecommendService.getAllHomeRecommend());
    }
}
