package com.zcf.universe.controller.api;

import com.zcf.universe.common.utils.IDUtils;
import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.service.MallOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by YuanQJ on 2018/11/18.
 */
@RestController
@Api(value = "商城订单管理控制器", tags = {"商城订单管理接口"})
public class MallOrderController {

    @Autowired
    private MallOrderService mallOrderService;

    //创建订单
    @ApiOperation(value = "创建订单")
    @PostMapping("mallorder")
    public ResponseEntity<Void> addOrder(MallOrder mallOrder) {
        mallOrder.setOrderId(IDUtils.genItemId());
        mallOrder.setOrderCompany("");
        mallOrder.setOrderExpressNumber("");
        mallOrder.setCreateTime(new Date());
        mallOrder.setUpdateTime(new Date());
        mallOrder.setOrderStatus(0);
        this.mallOrderService.addMallOrder(mallOrder);
        return ResponseEntity.ok(null);
    }

    //订单付款
    @ApiOperation(value = "订单付款")
    @PutMapping("update_mallorder")
    public ResponseEntity<Void> updateOrder(String orderid, Integer userid
            , String money, String paytype) {
        return this.mallOrderService.updateOrder(orderid, userid, money, paytype);
    }

    //订单收货
    @ApiOperation(value = "订单收货")
    @PutMapping("get_mallorder")
    public ResponseEntity<Void> updateOrderGetGoods(String orderid, String userid) {
        return this.mallOrderService.updateOrderGetGoods(orderid, userid);
    }

    @ApiOperation(value = "获取订单的信息")
    @GetMapping("mallOrder/{id}")
    public ResponseEntity<MallOrder> getMallOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallOrderService.getMallOrder(id));
    }

    @ApiOperation(value = "查询用户商城的订单")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "用户的Id", required = true, dataType = "Integer"),
    })
    @GetMapping("mallOrderUser")
    public ResponseEntity<List<MallOrder>> getMallOrderUser(@RequestParam Integer userId) {
        return ResponseEntity.ok(this.mallOrderService.getMallOrderUser(userId));
    }

}
