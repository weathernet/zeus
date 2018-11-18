package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.service.MallOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/18.
*/
@RestController
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class MallOrderController {

    @Autowired
    private MallOrderService mallOrderService;

    @ApiOperation(value = "新增")
    @PostMapping("mallOrder")
    public ResponseEntity<Void> addMallOrder(MallOrder mallOrder) {
        this.mallOrderService.addMallOrder(mallOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mallOrder/{id}")
    public ResponseEntity<Void> deleteMallOrder(@PathVariable Integer id) {
        this.mallOrderService.deleteMallOrder(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("mallOrder")
    public ResponseEntity<Void> updateMallOrder(MallOrder mallOrder) {
        this.mallOrderService.updateMallOrder(mallOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("mallOrder/{id}")
    public ResponseEntity<MallOrder> getMallOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallOrderService.getMallOrder(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MallOrder")
    public  ResponseEntity<List<MallOrder>> getAllMallOrder() {
       return ResponseEntity.ok(this.mallOrderService.getAllMallOrder());
    }
}
