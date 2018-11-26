package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.OwnerCase;
import com.zcf.universe.service.OwnerCaseService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

/**
* Created by YuanQJ on 2018/11/22.
*/
@RestController
@Api(value = "业主案例控制器", tags = {"业主案例接口"})
public class OwnerCaseController {

    @Autowired
    private OwnerCaseService ownerCaseService;

    @ApiOperation(value = "新增")
    @PostMapping("ownerCase")
    public ResponseEntity<Void> addOwnerCase(OwnerCase ownerCase) {
        this.ownerCaseService.addOwnerCase(ownerCase);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("ownerCase/{id}")
    public ResponseEntity<Void> deleteOwnerCase(@PathVariable Integer id) {
        this.ownerCaseService.deleteOwnerCase(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改")
    @PutMapping("ownerCase")
    public ResponseEntity<Void> updateOwnerCase(OwnerCase ownerCase) {
        this.ownerCaseService.updateOwnerCase(ownerCase);
        return ResponseEntity.ok(null);
    }

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
