package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MoveDetails;
import com.zcf.universe.service.MoveDetailsService;
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
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class MoveDetailsController {

    @Autowired
    private MoveDetailsService moveDetailsService;

    @ApiOperation(value = "新增")
    @PostMapping("moveDetails")
    public ResponseEntity<Void> addMoveDetails(MoveDetails moveDetails) {
        this.moveDetailsService.addMoveDetails(moveDetails);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("moveDetails/{id}")
    public ResponseEntity<Void> deleteMoveDetails(@PathVariable Integer id) {
        this.moveDetailsService.deleteMoveDetails(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("moveDetails")
    public ResponseEntity<Void> updateMoveDetails(MoveDetails moveDetails) {
        this.moveDetailsService.updateMoveDetails(moveDetails);
        return ResponseEntity.ok(null);
    }

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
