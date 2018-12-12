package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.TravelGroup;
import com.zcf.universe.service.TravelGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/19.
*/
@RestController
@Api(value = "景点分类管理控制器", tags = {"景点分类管理接口"})
public class TravelGroupController {

    @Autowired
    private TravelGroupService travelGroupService;

    @ApiOperation(value = "获取所有")
    @GetMapping("TravelGroup")
    public  ResponseEntity<List<TravelGroup>> getAllTravelGroup() {
       return ResponseEntity.ok(this.travelGroupService.getAllTravelGroup());
    }
}
