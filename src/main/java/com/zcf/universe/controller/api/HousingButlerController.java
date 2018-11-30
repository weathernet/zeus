package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.HousingButler;
import com.zcf.universe.service.HousingButlerService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/28.
 */
@RestController
@Api(value = "管家控制器", tags = {"管家控制接口"})
public class HousingButlerController {

    @Autowired
    private HousingButlerService housingButlerService;

    @ApiOperation(value = "获取管家的信息")
    @GetMapping("housingButler/{id}")
    public ResponseEntity<HousingButler> getHousingButler(@PathVariable Integer id) {
        return ResponseEntity.ok(this.housingButlerService.getHousingButler(id));
    }

}
