package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MallGroup;
import com.zcf.universe.service.MallGroupService;
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
@Api(value = "商城分类管理控制器", tags = {"商城分类管理接口"})
public class MallGroupController {

    @Autowired
    private MallGroupService mallGroupService;

    @ApiOperation(value = "获取所有分组")
    @GetMapping("MallGroup")
    public  ResponseEntity<List<MallGroup>> getAllMallGroup() {
       return ResponseEntity.ok(this.mallGroupService.getAllMallGroup());
    }
}
