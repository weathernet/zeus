package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.OwnerCase;
import com.zcf.universe.service.OwnerCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/22.
*/
@RestController
@Api(value = "业主案例控制器", tags = {"业主案例接口"})
public class OwnerCaseController {

    @Autowired
    private OwnerCaseService ownerCaseService;

    @ApiOperation(value = "获取单个")
    @GetMapping("ownerCase/{id}")
    public ResponseEntity<OwnerCase> getOwnerCase(@PathVariable Integer id) {
        return ResponseEntity.ok(this.ownerCaseService.getOwnerCase(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("OwnerCase")
    public  ResponseEntity<List<OwnerCase>> getAllOwnerCase() {
       return ResponseEntity.ok(this.ownerCaseService.getAllOwnerCase());
    }
}
