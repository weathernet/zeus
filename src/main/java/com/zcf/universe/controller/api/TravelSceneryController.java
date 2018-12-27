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
@Api(value = "景点管理控制器", tags = {"景点管理接口"})
public class TravelSceneryController {

    @Autowired
    private TravelSceneryService travelSceneryService;


    @ApiOperation(value = "根据搜索条件获取景点")
    @GetMapping("scenery/{keywords}")
    public ResponseEntity<List<TravelScenery>> getTravelScenery(@PathVariable String keywords) {
        return ResponseEntity.ok(this.travelSceneryService.searchTravelScenery(keywords));
    }

    @ApiOperation(value = "根据分组数据获取景点")
    @GetMapping("scenery/group/{groupid}")
    public ResponseEntity<List<TravelScenery>> getTravelSceneryByGroup(@PathVariable String groupid) {
        return ResponseEntity.ok(this.travelSceneryService.searchTravelSceneryByGroup(groupid));
    }

    @ApiOperation(value = "获取景点的具体信息")
    @GetMapping("travelScenery/{id}")
    public ResponseEntity<TravelScenery> getTravelScenery(@PathVariable Integer id) {
        return ResponseEntity.ok(this.travelSceneryService.getTravelScenery(id));
    }

    @ApiOperation(value = "获取所有的景点")
    @GetMapping("TravelScenery")
    public ResponseEntity<List<TravelScenery>> getAllTravelScenery() {
        return ResponseEntity.ok(this.travelSceneryService.getAllTravelScenery());
    }
}
