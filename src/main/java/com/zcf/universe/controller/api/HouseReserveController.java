package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.HouseReserve;
import com.zcf.universe.service.HouseReserveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity addHouseReserve(HouseReserve houseReserve) {
        this.houseReserveService.addHouseReserve(houseReserve);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("houseReserve/{id}")
    public ResponseEntity<Void> deleteHouseReserve(@PathVariable Integer id) {
        this.houseReserveService.deleteHouseReserve(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "用户取消约看")
    @PutMapping ("houseReserve/{id}")
    @ApiImplicitParam(name = "id", value = "约看的主键", required = true, dataType = "Integer")
    public ResponseEntity<Void> cancelHouseReserve(@PathVariable Integer id) {
        this.houseReserveService.cancelHouseReserve(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @ApiOperation(value = "获取用户未完成的预约信息")
    @GetMapping("houseReserve/{id}")
    public ResponseEntity<List<HouseReserve>> getHouseReserve(@PathVariable Integer id) {
        return ResponseEntity.ok(this.houseReserveService.getHouseReserve(id));
    }


    @ApiOperation(value = "获取用户非未完成的预约信息")
    @GetMapping("houseReserveStatus/{id}")
    public ResponseEntity<List<HouseReserve>> houseReserveStatus(@PathVariable Integer id) {
        return ResponseEntity.ok(this.houseReserveService.houseReserveStatus(id));
    }


}
