package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.OwnerQuotation;
import com.zcf.universe.service.OwnerQuotationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/26
 */
@RestController
@Api(value = "业主租金行情控制器", tags = {"业主租金行情接口"})
public class OwnerQuotationController {

    @Autowired
    private OwnerQuotationService ownerQuotationService;

    @ApiOperation(value = "获取该城市租金行情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "city", value = "城市名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "户室情况", required = true, dataType = "String"),
    })
    @GetMapping("OwnerQuotation")
    public ResponseEntity<List<OwnerQuotation>> getAllOwnerQuotation(@RequestParam String city, @RequestParam String type) {
        return ResponseEntity.ok(this.ownerQuotationService.searchOwnerQuotation(city, type));
    }
}
