package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.TravelScenery;
import com.zcf.universe.service.TravelSceneryService;
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
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class TravelSceneryController {

    @Autowired
    private TravelSceneryService travelSceneryService;

    @ApiOperation(value = "新增")
    @PostMapping("travelScenery")
    public ResponseEntity<Void> addTravelScenery(TravelScenery travelScenery) {
        this.travelSceneryService.addTravelScenery(travelScenery);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("travelScenery/{id}")
    public ResponseEntity<Void> deleteTravelScenery(@PathVariable Integer id) {
        this.travelSceneryService.deleteTravelScenery(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("travelScenery")
    public ResponseEntity<Void> updateTravelScenery(TravelScenery travelScenery) {
        this.travelSceneryService.updateTravelScenery(travelScenery);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("travelScenery/{id}")
    public ResponseEntity<TravelScenery> getTravelScenery(@PathVariable Integer id) {
        return ResponseEntity.ok(this.travelSceneryService.getTravelScenery(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("TravelScenery")
    public  ResponseEntity<List<TravelScenery>> getAllTravelScenery() {
       return ResponseEntity.ok(this.travelSceneryService.getAllTravelScenery());
    }
}
