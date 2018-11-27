package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.TravelEvaluate;
import com.zcf.universe.service.TravelEvaluateService;
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
@Api(value = "景点评论管理控制器", tags = {"景点评论管理接口"})
public class TravelEvaluateController {

    @Autowired
    private TravelEvaluateService travelEvaluateService;

    //评论景点
    @ApiOperation(value = "评论景点")
    @PostMapping("crt_travelEvaluate")
    public ResponseEntity<Void> addEvaluate(TravelEvaluate travelEvaluate) {
        this.travelEvaluateService.addEvaluate(travelEvaluate);
        return ResponseEntity.ok(null);
    }

    //查询景点评论
    @ApiOperation(value = "查询景点评论")
    @PostMapping("sel_travelevaluate")
    public ResponseEntity<Void> getEvaluate(String evaluateSceneryId) {
        this.travelEvaluateService.searchTravelEvaluate(evaluateSceneryId);
        return ResponseEntity.ok(null);
    }

    /**********************************************************************************/

    @ApiOperation(value = "新增")
    @PostMapping("travelEvaluate")
    public ResponseEntity<Void> addTravelEvaluate(TravelEvaluate travelEvaluate) {
        this.travelEvaluateService.addTravelEvaluate(travelEvaluate);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("travelEvaluate/{id}")
    public ResponseEntity<Void> deleteTravelEvaluate(@PathVariable Integer id) {
        this.travelEvaluateService.deleteTravelEvaluate(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("travelEvaluate")
    public ResponseEntity<Void> updateTravelEvaluate(TravelEvaluate travelEvaluate) {
        this.travelEvaluateService.updateTravelEvaluate(travelEvaluate);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("travelEvaluate/{id}")
    public ResponseEntity<TravelEvaluate> getTravelEvaluate(@PathVariable Integer id) {
        return ResponseEntity.ok(this.travelEvaluateService.getTravelEvaluate(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("TravelEvaluate")
    public  ResponseEntity<List<TravelEvaluate>> getAllTravelEvaluate() {
       return ResponseEntity.ok(this.travelEvaluateService.getAllTravelEvaluate());
    }
}
