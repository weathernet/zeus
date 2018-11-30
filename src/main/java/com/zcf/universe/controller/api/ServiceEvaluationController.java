package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.ServiceEvaluation;
import com.zcf.universe.service.ServiceEvaluationService;
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
@Api(value = "服务评价控制器", tags = {"服务评价接口"})
public class ServiceEvaluationController {

    @Autowired
    private ServiceEvaluationService serviceEvaluationService;

    @ApiOperation(value = "新增")
    @PostMapping("serviceEvaluation")
    public ResponseEntity<Void> addServiceEvaluation(ServiceEvaluation serviceEvaluation) {
        this.serviceEvaluationService.addServiceEvaluation(serviceEvaluation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("serviceEvaluation/{id}")
    public ResponseEntity<Void> deleteServiceEvaluation(@PathVariable Integer id) {
        this.serviceEvaluationService.deleteServiceEvaluation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改")
    @PutMapping("serviceEvaluation")
    public ResponseEntity<Void> updateServiceEvaluation(ServiceEvaluation serviceEvaluation) {
        this.serviceEvaluationService.updateServiceEvaluation(serviceEvaluation);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("serviceEvaluation/{id}")
    public ResponseEntity<ServiceEvaluation> getServiceEvaluation(@PathVariable Integer id) {
        return ResponseEntity.ok(this.serviceEvaluationService.getServiceEvaluation(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("ServiceEvaluation")
    public  ResponseEntity<List<ServiceEvaluation>> getAllServiceEvaluation() {
       return ResponseEntity.ok(this.serviceEvaluationService.getAllServiceEvaluation());
    }
}
