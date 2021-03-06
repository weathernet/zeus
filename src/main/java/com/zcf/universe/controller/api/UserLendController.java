package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.UserLend;
import com.zcf.universe.service.UserLendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@RestController
@Api(value = "用户贷款控制器", tags = {"用户贷款控制器"})
public class UserLendController {

    @Autowired
    private UserLendService userLendService;

    @ApiOperation(value = "添加贷款信息")
    @PostMapping("userLend")
    public ResponseEntity<Void> addUserLend(UserLend userLend) {
        this.userLendService.addUserLend(userLend);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取用户的是否有贷款信息")
    @GetMapping("userLend/{id}")
    public ResponseEntity<Boolean> getUserLendStatus(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userLendService.getUserLendStatus(id));
    }


    @ApiOperation(value = "获取当前用户的借款信息")
    @GetMapping("UserLend")
    public ResponseEntity<List<UserLend>> getAllUserLend(Integer id) {
        return ResponseEntity.ok(this.userLendService.getAllUserLend(id));
    }
}
