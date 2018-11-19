package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.TravelTicket;
import com.zcf.universe.service.TravelTicketService;
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
public class TravelTicketController {

    @Autowired
    private TravelTicketService travelTicketService;

    @ApiOperation(value = "新增")
    @PostMapping("travelTicket")
    public ResponseEntity<Void> addTravelTicket(TravelTicket travelTicket) {
        this.travelTicketService.addTravelTicket(travelTicket);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("travelTicket/{id}")
    public ResponseEntity<Void> deleteTravelTicket(@PathVariable Integer id) {
        this.travelTicketService.deleteTravelTicket(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("travelTicket")
    public ResponseEntity<Void> updateTravelTicket(TravelTicket travelTicket) {
        this.travelTicketService.updateTravelTicket(travelTicket);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("travelTicket/{id}")
    public ResponseEntity<TravelTicket> getTravelTicket(@PathVariable Integer id) {
        return ResponseEntity.ok(this.travelTicketService.getTravelTicket(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("TravelTicket")
    public  ResponseEntity<List<TravelTicket>> getAllTravelTicket() {
       return ResponseEntity.ok(this.travelTicketService.getAllTravelTicket());
    }
}
