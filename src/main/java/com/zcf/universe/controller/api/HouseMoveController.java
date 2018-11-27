package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.HouseMove;
import com.zcf.universe.service.HouseMoveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/14.
*/
@RestController
@Api(value = "搬家菜单控制器", tags = {"搬家菜单接口"})
public class HouseMoveController {

    @Autowired
    private HouseMoveService houseMoveService;


    @ApiOperation(value = "获取单个")
    @GetMapping("houseMove/{id}")
    public ResponseEntity<HouseMove> getHouseMove(@PathVariable Integer id) {
        return ResponseEntity.ok(this.houseMoveService.getHouseMove(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("HouseMove")
    public  ResponseEntity<List<HouseMove>> getAllHouseMove() {
       return ResponseEntity.ok(this.houseMoveService.getAllHouseMove());
    }
}
