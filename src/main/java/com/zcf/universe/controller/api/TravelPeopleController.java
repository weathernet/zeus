package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.TravelPeople;
import com.zcf.universe.service.TravelPeopleService;
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
public class TravelPeopleController {

    @Autowired
    private TravelPeopleService travelPeopleService;

    @ApiOperation(value = "新增")
    @PostMapping("travelPeople")
    public ResponseEntity<Void> addTravelPeople(TravelPeople travelPeople) {
        this.travelPeopleService.addTravelPeople(travelPeople);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("travelPeople/{id}")
    public ResponseEntity<Void> deleteTravelPeople(@PathVariable Integer id) {
        this.travelPeopleService.deleteTravelPeople(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("travelPeople")
    public ResponseEntity<Void> updateTravelPeople(TravelPeople travelPeople) {
        this.travelPeopleService.updateTravelPeople(travelPeople);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("travelPeople/{id}")
    public ResponseEntity<TravelPeople> getTravelPeople(@PathVariable Integer id) {
        return ResponseEntity.ok(this.travelPeopleService.getTravelPeople(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("TravelPeople")
    public  ResponseEntity<List<TravelPeople>> getAllTravelPeople() {
       return ResponseEntity.ok(this.travelPeopleService.getAllTravelPeople());
    }
}
