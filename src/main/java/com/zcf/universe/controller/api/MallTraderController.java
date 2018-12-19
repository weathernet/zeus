package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MallTrader;
import com.zcf.universe.service.MallTraderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/18.
 */
@RestController
@Api(value = "商户管理控制器", tags = {"商户管理接口"})
public class MallTraderController {

    @Autowired
    private MallTraderService mallTraderService;

    @ApiOperation(value = "商家账户登录")
    @GetMapping("mallTrader")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "traderName", value = "商户名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "traderPassword", value = "密码", required = true, dataType = "String"),
    })
    public ResponseEntity<MallTrader> getMallTrader(@RequestParam String traderName, @RequestParam String traderPassword) {
        return ResponseEntity.ok(this.mallTraderService.getMallTrader(traderName, traderPassword));
    }

}
