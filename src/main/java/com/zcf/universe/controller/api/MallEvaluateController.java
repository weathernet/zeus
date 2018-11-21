package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.MallEvaluate;
import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.service.MallEvaluateService;
import com.zcf.universe.service.MallOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

/**
* Created by YuanQJ on 2018/11/18.
*/
@RestController
@Api(value = "评论管理控制器", tags = {"评论管理接口"})
public class MallEvaluateController {

    @Autowired
    private MallEvaluateService mallEvaluateService;


    @Autowired
    private MallOrderService mallOrderService;

    //发布评论
    @ApiOperation(value = "发布评论")
    @PostMapping("evaluate")
    public ResponseEntity<Void> addEvaluate(MallEvaluate mallEvaluate,String orderid) {
        //添加评论
        this.mallEvaluateService.addMallEvaluate(mallEvaluate);
        //修改订单状态（已评论）
        MallOrder mallOrder = new MallOrder();
        mallOrder.setUpdateTime(new Date());
        mallOrder.setOrderStatus(4);
        mallOrder.setOrderId(Long.parseLong(orderid));
        mallOrderService.updateMallOrder(mallOrder);
        return ResponseEntity.ok(null);
    }


/****************************************************************************/
    @ApiOperation(value = "新增")
    @PostMapping("mallEvaluate")
    public ResponseEntity<Void> addMallEvaluate(MallEvaluate mallEvaluate) {
        this.mallEvaluateService.addMallEvaluate(mallEvaluate);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mallEvaluate/{id}")
    public ResponseEntity<Void> deleteMallEvaluate(@PathVariable Integer id) {
        this.mallEvaluateService.deleteMallEvaluate(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("mallEvaluate")
    public ResponseEntity<Void> updateMallEvaluate(MallEvaluate mallEvaluate) {
        this.mallEvaluateService.updateMallEvaluate(mallEvaluate);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("mallEvaluate/{id}")
    public ResponseEntity<MallEvaluate> getMallEvaluate(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallEvaluateService.getMallEvaluate(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MallEvaluate")
    public  ResponseEntity<List<MallEvaluate>> getAllMallEvaluate() {
       return ResponseEntity.ok(this.mallEvaluateService.getAllMallEvaluate());
    }
}
