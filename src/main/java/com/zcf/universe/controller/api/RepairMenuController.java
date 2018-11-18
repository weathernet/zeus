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

    @ApiOperation(value = "新增")
    @PostMapping("repairMenu")
    public ResponseEntity<Void> addRepairMenu(RepairMenu repairMenu) {
        this.repairMenuService.addRepairMenu(repairMenu);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("repairMenu/{id}")
    public ResponseEntity<Void> deleteRepairMenu(@PathVariable Integer id) {
        this.repairMenuService.deleteRepairMenu(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("repairMenu")
    public ResponseEntity<Void> updateRepairMenu(RepairMenu repairMenu) {
        this.repairMenuService.updateRepairMenu(repairMenu);
        return ResponseEntity.ok(null);
    }

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
