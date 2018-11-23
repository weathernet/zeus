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
@Api(value = "OwnerNews控制器", tags = {"OwnerNews接口"})
public class OwnerNewsController {

    @Autowired
    private OwnerNewsService ownerNewsService;

    @ApiOperation(value = "新增")
    @PostMapping("ownerNews")
    public ResponseEntity<Void> addOwnerNews(OwnerNews ownerNews) {
        this.ownerNewsService.addOwnerNews(ownerNews);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("ownerNews/{id}")
    public ResponseEntity<Void> deleteOwnerNews(@PathVariable Integer id) {
        this.ownerNewsService.deleteOwnerNews(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改")
    @PutMapping("ownerNews")
    public ResponseEntity<Void> updateOwnerNews(OwnerNews ownerNews) {
        this.ownerNewsService.updateOwnerNews(ownerNews);
        return ResponseEntity.ok(null);
    }

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
