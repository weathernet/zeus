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
@Api(value = "景点订票人管理控制器", tags = {"景点订票人管理接口"})
public class TravelPeopleController {

    @Autowired
    private TravelPeopleService travelPeopleService;

    @ApiOperation(value = "获取用户所有的订票人")
    @PostMapping("people")
    public ResponseEntity<List<TravelPeople>> getAllTravelPeople(String userid) {
        return ResponseEntity.ok(this.travelPeopleService.searchTravelPeople(userid));
    }

    @ApiOperation(value = "新增订票的用户")
    @PostMapping("travelPeople")
    public ResponseEntity<Void> addTravelPeople(TravelPeople travelPeople) {
        this.travelPeopleService.addTravelPeople(travelPeople);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除订票的用户")
    @DeleteMapping("travelPeople/{id}")
    public ResponseEntity<Void> deleteTravelPeople(@PathVariable Integer id) {
        this.travelPeopleService.deleteTravelPeople(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改订票人的信息")
    @PutMapping("travelPeople")
    public ResponseEntity<Void> updateTravelPeople(TravelPeople travelPeople) {
        this.travelPeopleService.updateTravelPeople(travelPeople);
        return ResponseEntity.ok(null);
    }

}
