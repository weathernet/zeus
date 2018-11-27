package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.ServiceCleanup;
import com.zcf.universe.service.ServiceCleanupService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

/**
* Created by YuanQJ on 2018/11/26.
*/
@RestController
@Api(value = "ServiceCleanup控制器", tags = {"ServiceCleanup接口"})
public class ServiceCleanupController {

    @Autowired
    private ServiceCleanupService serviceCleanupService;

    @ApiOperation(value = "新增")
    @PostMapping("serviceCleanup")
    public ResponseEntity<Void> addServiceCleanup(ServiceCleanup serviceCleanup) {
        this.serviceCleanupService.addServiceCleanup(serviceCleanup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("serviceCleanup/{id}")
    public ResponseEntity<Void> deleteServiceCleanup(@PathVariable Integer id) {
        this.serviceCleanupService.deleteServiceCleanup(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改")
    @PutMapping("serviceCleanup")
    public ResponseEntity<Void> updateServiceCleanup(ServiceCleanup serviceCleanup) {
        this.serviceCleanupService.updateServiceCleanup(serviceCleanup);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("serviceCleanup/{id}")
    public ResponseEntity<ServiceCleanup> getServiceCleanup(@PathVariable Integer id) {
        return ResponseEntity.ok(this.serviceCleanupService.getServiceCleanup(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("ServiceCleanup")
    public  ResponseEntity<List<ServiceCleanup>> getAllServiceCleanup() {
       return ResponseEntity.ok(this.serviceCleanupService.getAllServiceCleanup());
    }
}
