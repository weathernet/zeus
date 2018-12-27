package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.HouseEvaluation;
import com.zcf.universe.service.HouseEvaluationService;
import io.swagger.annotations.Api;
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
@Api(value = "房源评价控制器", tags = {"房源评价接口"})
public class HouseEvaluationController {

    @Autowired
    private HouseEvaluationService houseEvaluationService;


    @ApiOperation(value = "获取用户所有房源的评价")
    @GetMapping("HouseEvaluation")
    public ResponseEntity<List<HouseEvaluation>> getAllHouseEvaluation(@RequestParam Integer userId) {
        return ResponseEntity.ok(this.houseEvaluationService.getAllHouseEvaluationByUser(userId));
    }
}
