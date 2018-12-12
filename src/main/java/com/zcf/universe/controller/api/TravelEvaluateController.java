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

    //查询景点评论
    @ApiOperation(value = "搜索该景点的评论")
    @PostMapping("travelEvaluateById")
    public ResponseEntity<List<TravelEvaluate>> getEvaluate(Integer evaluateSceneryId) {
        return ResponseEntity.ok(this.travelEvaluateService.searchTravelEvaluate(evaluateSceneryId));
    }


    @ApiOperation(value = "评论景点")
    @PostMapping("travelEvaluate")
    public ResponseEntity<Void> addTravelEvaluate(TravelEvaluate travelEvaluate) {
        this.travelEvaluateService.addTravelEvaluate(travelEvaluate);
        return ResponseEntity.ok(null);
    }


    @ApiOperation(value = "获取单个")
    @GetMapping("travelEvaluate/{id}")
    public ResponseEntity<TravelEvaluate> getTravelEvaluate(@PathVariable Integer id) {
        return ResponseEntity.ok(this.travelEvaluateService.getTravelEvaluate(id));
    }

}
