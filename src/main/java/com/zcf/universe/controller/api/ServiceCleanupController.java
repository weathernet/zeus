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
@Api(value = "清洁服务控制器", tags = {"清洁服务   接口"})
public class ServiceCleanupController {

    @Autowired
    private ServiceCleanupService serviceCleanupService;

    @ApiOperation(value = "获取详情")
    @GetMapping("serviceCleanup/{id}")
    public ResponseEntity<ServiceCleanup> getServiceCleanup(@PathVariable Integer id) {
        return ResponseEntity.ok(this.serviceCleanupService.getServiceCleanup(id));
    }

    @ApiOperation(value = "获取所有的保洁服务")
    @GetMapping("ServiceCleanup")
    public  ResponseEntity<List<ServiceCleanup>> getAllServiceCleanup() {
       return ResponseEntity.ok(this.serviceCleanupService.getAllServiceCleanup());
    }
}
