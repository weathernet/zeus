package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.HouseProperty;
import com.zcf.universe.service.HousePropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @author 袁齐吉
* @date 2018/12/28
*/
@RestController
@Api(value = "HouseProperty控制器", tags = {"HouseProperty接口"})
public class HousePropertyController {

    @Autowired
    private HousePropertyService housePropertyService;

    @ApiOperation(value = "新增")
    @PostMapping("houseProperty")
    public ResponseEntity<Void> addHouseProperty(HouseProperty houseProperty) {
        this.housePropertyService.addHouseProperty(houseProperty);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("houseProperty/{id}")
    public ResponseEntity<Void> deleteHousePropertyById(@PathVariable Integer id) {
        this.housePropertyService.deleteHousePropertyById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改")
    @PutMapping("houseProperty")
    public ResponseEntity<Void> updateHouseProperty(HouseProperty houseProperty) {
        this.housePropertyService.updateHouseProperty(houseProperty);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("houseProperty/{id}")
    public ResponseEntity<HouseProperty> getHouseProperty(@PathVariable Integer id) {
        return ResponseEntity.ok(this.housePropertyService.getHouseProperty(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("HouseProperty")
    public  ResponseEntity<List<HouseProperty>> getAllHouseProperty() {
       return ResponseEntity.ok(this.housePropertyService.getAllHouseProperty());
    }
}
