package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.RepairMenu;
import com.zcf.universe.service.RepairMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/12.
*/
@RestController
@Api(value = "维修主菜单控制器", tags = {"维修主菜单接口"})
public class RepairMenuController {

    @Autowired
    private RepairMenuService repairMenuService;

    @ApiOperation(value = "获取单个")
    @GetMapping("repairMenu/{id}")
    public ResponseEntity<RepairMenu> getRepairMenu(@PathVariable Integer id) {
        return ResponseEntity.ok(this.repairMenuService.getRepairMenu(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("RepairMenu")
    public  ResponseEntity<List<RepairMenu>> getAllRepairMenu() {
       return ResponseEntity.ok(this.repairMenuService.getAllRepairMenu());
    }
}
