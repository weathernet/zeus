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
@Api(value = "景点门票管理控制器", tags = {"景点门票首页管理接口"})
public class TravelTicketController {
    @Autowired
    private TravelTicketService travelTicketService;

    @ApiOperation(value = "获取景点门票信息")
    @PostMapping("get_travelticket")
    public ResponseEntity<Void> getTicket(String sceneryId) {
        this.travelTicketService.searchTravelTicket(sceneryId);
        return ResponseEntity.ok(null);
    }

}
