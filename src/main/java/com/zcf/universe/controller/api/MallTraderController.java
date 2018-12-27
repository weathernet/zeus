package com.zcf.universe.controller.api;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.pojo.MallGoods;
import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.pojo.MallTrader;
import com.zcf.universe.service.MallGoodsService;
import com.zcf.universe.service.MallOrderService;
import com.zcf.universe.service.MallTraderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/18.
 */
@RestController
@Api(value = "商户管理控制器", tags = {"商户管理接口"})
public class MallTraderController {

    @Autowired
    private MallTraderService mallTraderService;
    @Autowired
    private MallGoodsService mallGoodsService;
    @Autowired
    private MallOrderService mallOrderService;

    @ApiOperation(value = "商家账户登录")
    @GetMapping("mallTrader")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "traderName", value = "商户名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "traderPassword", value = "密码", required = true, dataType = "String"),
    })
    public ResponseEntity<MallTrader> getMallTrader(@RequestParam String traderName, @RequestParam String traderPassword) {
        return ResponseEntity.ok(this.mallTraderService.getMallTrader(traderName, traderPassword));
    }

    @ApiOperation(value = "商家端新增商品")
    @PostMapping("mallGoods")
    public ResponseEntity<Void> addMallGoods(MallGoods mallGoods) {
        this.mallGoodsService.addMallGoods(mallGoods);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "商家端删除商品")
    @DeleteMapping("mallGoods/{id}")
    public ResponseEntity<Void> deleteMallGoods(@PathVariable Integer id) {
        this.mallGoodsService.deleteMallGoods(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "商家端修改商品的信息")
    @PutMapping("mallGoods")
    public ResponseEntity<Void> updateMallGoods(MallGoods mallGoods) {
        this.mallGoodsService.updateMallGoods(mallGoods);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "商家所有的商品")
    @ApiImplicitParam(name = "userId", value = "商家的主键", required = true, dataType = "Integer")
    @GetMapping("mallAllGoods")
    public ResponseEntity<List<MallGoods>> mallAllGoods(@RequestParam Integer traderId) {
        return ResponseEntity.ok(this.mallGoodsService.mallAllGoods(traderId));
    }

    @ApiOperation(value = "商家端根据状态查询订单")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "traderId", value = "商家的主键", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "订单的状态", required = true, dataType = "Integer"),
    })
    @GetMapping("mallOrderTrader")
    public ResponseEntity<List<MallOrder>> mallOrderTrader(@RequestParam Integer traderId, Integer status) {
        return ResponseEntity.ok(this.mallOrderService.mallOrderTrader(traderId, status));
    }

    @PostMapping("mallImage")
    @ApiOperation(value = "商家商城上传图片")
    public ResponseEntity<String> uploadMallImage(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(FileUploadUtils.fileUpload(file, "", "goods/"));
    }

    @PostMapping("mallDetailsImage")
    @ApiOperation(value = "商家商城上传详情图片")
    public ResponseEntity<String> uploadMallDetailsImage(@RequestParam("file") MultipartFile[] file) {
        return ResponseEntity.ok(FileUploadUtils.filesUpload(file, "", "goods/"));
    }

    //订单发货
    @ApiOperation(value = "商家端订单发货")
    @PostMapping("sendMallOrder")
    public ResponseEntity<Void> updateOrderSendGoods(Long orderId, String userId, String orderExpressNumber, String orderCompany) {
        this.mallOrderService.updateOrderSendGoods(orderId, userId, orderCompany, orderExpressNumber);
        return ResponseEntity.ok().build();
    }

}
