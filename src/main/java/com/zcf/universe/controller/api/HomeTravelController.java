package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.HomeTravel;
import com.zcf.universe.service.HomeTravelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 袁齐吉
 * @date 2018/12/28
 */
@RestController
@Api(value = "首页旅行控制器", tags = {"首页旅行接口"})
public class HomeTravelController {

    @Autowired
    private HomeTravelService homeTravelService;

    @ApiOperation(value = "获取单个")
    @GetMapping("homeTravel/{id}")
    public ResponseEntity<HomeTravel> getHomeTravel(@PathVariable Integer id) {
        return ResponseEntity.ok(this.homeTravelService.getHomeTravel(id));
    }

}
