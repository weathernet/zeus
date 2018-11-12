package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.HouseReserve;
import com.zcf.universe.service.HouseReserveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/09.
*/
@RestController
@Api(value = "房源预约控制器", tags = {"房源预约控制器"})
public class HouseReserveController {

    @Autowired
    private HouseReserveService houseReserveService;

    @ApiOperation(value = "预约房源")
    @PostMapping("houseReserve")
    public ResponseEntity<Void> addHouseReserve(HouseReserve houseReserve) {
        this.houseReserveService.addHouseReserve(houseReserve);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("houseReserve/{id}")
    public ResponseEntity<Void> deleteHouseReserve(@PathVariable Integer id) {
        this.houseReserveService.deleteHouseReserve(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("houseReserve")
    public ResponseEntity<Void> updateHouseReserve(HouseReserve houseReserve) {
        this.houseReserveService.updateHouseReserve(houseReserve);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("houseReserve/{id}")
    public ResponseEntity<HouseReserve> getHouseReserve(@PathVariable Integer id) {
        return ResponseEntity.ok(this.houseReserveService.getHouseReserve(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("HouseReserve")
    public  ResponseEntity<List<HouseReserve>> getAllHouseReserve() {
       return ResponseEntity.ok(this.houseReserveService.getAllHouseReserve());
    }
}
