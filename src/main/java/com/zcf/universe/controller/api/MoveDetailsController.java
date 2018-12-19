package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MoveDetails;
import com.zcf.universe.service.MoveDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/14.
*/
@RestController
@Api(value = "搬家详情控制器", tags = {"搬家详情接口"})
public class MoveDetailsController {

    @Autowired
    private MoveDetailsService moveDetailsService;

    @ApiOperation(value = "获取单个")
    @GetMapping("moveDetails/{id}")
    public ResponseEntity<MoveDetails> getMoveDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(this.moveDetailsService.getMoveDetails(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MoveDetails")
    public  ResponseEntity<List<MoveDetails>> getAllMoveDetails() {
       return ResponseEntity.ok(this.moveDetailsService.getAllMoveDetails());
    }
}
