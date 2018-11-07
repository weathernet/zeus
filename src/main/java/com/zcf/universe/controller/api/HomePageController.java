package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.HomeGroups;
import com.zcf.universe.service.HomePageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuan
 * @date 2018/11/7 0007
 */
@RestController
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    @GetMapping("homeGroup")
    @ApiOperation(value = "获取首页分类")
    public ResponseEntity<List<HomeGroups>> getHomeGroups() {
        List<HomeGroups> list = this.homePageService.getHomeGroups();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
