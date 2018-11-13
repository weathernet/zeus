package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.RepairSubmenu;
import com.zcf.universe.service.RepairSubmenuService;
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
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class RepairSubmenuController {

    @Autowired
    private RepairSubmenuService repairSubmenuService;

    @ApiOperation(value = "新增")
    @PostMapping("repairSubmenu")
    public ResponseEntity<Void> addRepairSubmenu(RepairSubmenu repairSubmenu) {
        this.repairSubmenuService.addRepairSubmenu(repairSubmenu);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("repairSubmenu/{id}")
    public ResponseEntity<Void> deleteRepairSubmenu(@PathVariable Integer id) {
        this.repairSubmenuService.deleteRepairSubmenu(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("repairSubmenu")
    public ResponseEntity<Void> updateRepairSubmenu(RepairSubmenu repairSubmenu) {
        this.repairSubmenuService.updateRepairSubmenu(repairSubmenu);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("repairSubmenu/{id}")
    public ResponseEntity<RepairSubmenu> getRepairSubmenu(@PathVariable Integer id) {
        return ResponseEntity.ok(this.repairSubmenuService.getRepairSubmenu(id));
    }

    @ApiOperation(value = "根据父级Id获取子集的数据")
    @GetMapping("repairParentMenu/{id}")
    public ResponseEntity<List<RepairSubmenu>> getRepairSubmenuByMenuId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.repairSubmenuService.getRepairSubmenuByMenuId(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("RepairSubmenu")
    public ResponseEntity<List<RepairSubmenu>> getAllRepairSubmenu() {
        return ResponseEntity.ok(this.repairSubmenuService.getAllRepairSubmenu());
    }
}
