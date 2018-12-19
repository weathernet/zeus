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
@Api(value = "商城评论管理控制器", tags = {"商城评论管理接口"})
public class MallEvaluateController {

    @Autowired
    private MallEvaluateService mallEvaluateService;


    @Autowired
    private MallOrderService mallOrderService;

    //发布评论
    @ApiOperation(value = "发布评论")
    @PostMapping("mallEvaluate")
    public ResponseEntity<Void> addEvaluate(MallEvaluate mallEvaluate, String orderId) {
        //添加评论
        this.mallEvaluateService.addMallEvaluate(mallEvaluate);
        //修改订单状态（已评论）
        MallOrder mallOrder = new MallOrder();
        mallOrder.setUpdateTime(new Date());
        mallOrder.setOrderStatus(4);
        mallOrder.setOrderId(Long.parseLong(orderId));
        mallOrderService.updateMallOrder(mallOrder);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取当前商家的评论")
    @GetMapping("MallEvaluateShop")
    public ResponseEntity<List<MallEvaluate>> getAllMallEvaluateByShop(@RequestParam Integer shopId) {
        return ResponseEntity.ok(this.mallEvaluateService.getAllMallEvaluateByShop(shopId));
    }

    @ApiOperation(value = "获取用户的评论")
    @GetMapping("MallEvaluateUser")
    public ResponseEntity<List<MallEvaluate>> getAllMallEvaluateByUser(@RequestParam Integer userId) {
        return ResponseEntity.ok(this.mallEvaluateService.getAllMallEvaluateByUser(userId));
    }
}
