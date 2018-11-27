package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.OwnerNews;
import com.zcf.universe.service.OwnerNewsService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

/**
* Created by YuanQJ on 2018/11/22.
*/
@RestController
@Api(value = "业主新闻控制器", tags = {"业主新闻接口"})
public class OwnerNewsController {

    @Autowired
    private OwnerNewsService ownerNewsService;

    @ApiOperation(value = "获取单个")
    @GetMapping("ownerNews/{id}")
    public ResponseEntity<OwnerNews> getOwnerNews(@PathVariable Integer id) {
        return ResponseEntity.ok(this.ownerNewsService.getOwnerNews(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("OwnerNews")
    public  ResponseEntity<List<OwnerNews>> getAllOwnerNews() {
       return ResponseEntity.ok(this.ownerNewsService.getAllOwnerNews());
    }
}
