package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.OwnerAdvantage;
import com.zcf.universe.service.OwnerAdvantageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@RestController
@Api(value = "业主品家优势控制器", tags = {"业主品家优势接口"})
public class OwnerAdvantageController {

    @Autowired
    private OwnerAdvantageService ownerAdvantageService;

    @ApiOperation(value = "获取所有")
    @GetMapping("OwnerAdvantage")
    public ResponseEntity<List<OwnerAdvantage>> getAllOwnerAdvantage() {
        return ResponseEntity.ok(this.ownerAdvantageService.getAllOwnerAdvantage());
    }
}
