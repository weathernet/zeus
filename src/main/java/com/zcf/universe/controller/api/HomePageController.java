package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.HomeBanner;
import com.zcf.universe.pojo.HomeGroups;
import com.zcf.universe.pojo.HomeStory;
import com.zcf.universe.service.HomePageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuan
 * @date 2018/11/7 0007
 */
@RestController
@Api(value = "首页分类控制器", tags = {"首页分类控制器"})
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    @GetMapping("homeGroup")
    @ApiOperation(value = "获取首页分类")

    public ResponseEntity<List<HomeGroups>> getHomeGroups() {
        return ResponseEntity.ok(this.homePageService.getHomeGroups());
    }

    @GetMapping("homeBanner")
    @ApiOperation(value = "获取首页轮播图")
    public ResponseEntity<List<HomeBanner>> getHomeBanner() {
        return ResponseEntity.ok(this.homePageService.getHomeBanner());
    }

    @GetMapping("homeStories")
    @ApiOperation(value = "获取所有的故事")
    public ResponseEntity<List<HomeStory>> getHomeStories() {
        return ResponseEntity.ok(this.homePageService.getHomeStories());
    }

    @GetMapping("homeStory/{id}")
    @ApiOperation(value = "获取所有的故事")
    public ResponseEntity<HomeStory> getHomeStory(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.homePageService.getHomeStory(id));
    }
}
