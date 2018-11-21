package com.zcf.universe.controller.api;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.common.utils.IDUtils;
import com.zcf.universe.mapper.UserInfoMapper;
import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.pojo.UserInfo;
import com.zcf.universe.service.MallOrderService;
import com.zcf.universe.service.UserInfoService;
import io.swagger.annotations.Api;
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
@Api(value = "订单管理控制器", tags = {"订单管理接口"})
public class MallOrderController {

    @Autowired
    private MallOrderService mallOrderService;



    @ApiOperation(value = "查询订单")
    @GetMapping("orders")
    public  ResponseEntity<List<MallOrder>> getOrder(String orderstate) {
        return ResponseEntity.ok(this.mallOrderService.searchOrder(orderstate));
    }

    //创建订单
    @ApiOperation(value = "创建订单")
    @PostMapping("order")
    public ResponseEntity<Void> addOrder(MallOrder mallOrder) {
        mallOrder.setOrderId(IDUtils.genItemId());
        mallOrder.setCreateTime(new Date());
        mallOrder.setUpdateTime(new Date());
        mallOrder.setOrderStatus(0);
        this.mallOrderService.addMallOrder(mallOrder);
        return ResponseEntity.ok(null);
    }

    //订单付款
    @ApiOperation(value = "订单付款")
    @PutMapping("update_order")
    public ResponseEntity<Void> updateOrder(String orderid,Integer userid
            ,String money,String paytype) {
        return this.mallOrderService.updateOrder(orderid,userid,money,paytype);
    }

    //订单发货
    @ApiOperation(value = "订单发货")
    @PutMapping("send_order")
    public ResponseEntity<Void> updateOrderSendGoods(String orderid,String userid,String expressnumber) {
        return this.mallOrderService.updateOrderSendGoods(orderid,userid,expressnumber);
    }

    //订单收货
    @ApiOperation(value = "订单收货")
    @PutMapping("get_order")
    public ResponseEntity<Void> updateOrderGetGoods(String orderid,String userid) {
        return this.mallOrderService.updateOrderGetGoods(orderid,userid);
    }


    /*************************************************************************/

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
