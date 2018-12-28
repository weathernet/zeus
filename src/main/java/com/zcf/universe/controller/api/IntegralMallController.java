package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.IntegralMall;
import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.service.IntegralMallService;
import com.zcf.universe.service.MallOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/18
 */
@RestController
@Api(value = "积分商城控制器", tags = {"积分商城接口"})
public class IntegralMallController {

    @Autowired
    private IntegralMallService integralMallService;
    @Autowired
    private MallOrderService mallOrderService;

    @ApiOperation(value = "获取商品的详情")
    @GetMapping("integralMall/{id}")
    public ResponseEntity<IntegralMall> getIntegralMall(@PathVariable Integer id) {
        return ResponseEntity.ok(this.integralMallService.getIntegralMall(id));
    }

    @ApiOperation(value = "获取所有积分的商品")
    @GetMapping("IntegralMall")
    public ResponseEntity<List<IntegralMall>> getAllIntegralMall() {
        return ResponseEntity.ok(this.integralMallService.getAllIntegralMall());
    }

    @ApiOperation(value = "使用积分兑换商品")
    @PostMapping("IntegralMall")
    public ResponseEntity addIntegralMall(MallOrder mallOrder) {
        this.mallOrderService.addIntegralMall(mallOrder);
        return ResponseEntity.ok().build();
    }

}
