package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.UserSearchHistory;
import com.zcf.universe.service.UserSearchHistoryService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

/**
* Created by YuanQJ on 2018/11/19.
*/
@RestController
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class UserSearchHistoryController {

    @Autowired
    private UserSearchHistoryService userSearchHistoryService;

    @ApiOperation(value = "新增")
    @PostMapping("userSearchHistory")
    public ResponseEntity<Void> addUserSearchHistory(UserSearchHistory userSearchHistory) {
        this.userSearchHistoryService.addUserSearchHistory(userSearchHistory);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("userSearchHistory/{id}")
    public ResponseEntity<Void> deleteUserSearchHistory(@PathVariable Integer id) {
        this.userSearchHistoryService.deleteUserSearchHistory(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("userSearchHistory")
    public ResponseEntity<Void> updateUserSearchHistory(UserSearchHistory userSearchHistory) {
        this.userSearchHistoryService.updateUserSearchHistory(userSearchHistory);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("userSearchHistory/{id}")
    public ResponseEntity<UserSearchHistory> getUserSearchHistory(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userSearchHistoryService.getUserSearchHistory(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("UserSearchHistory")
    public  ResponseEntity<List<UserSearchHistory>> getAllUserSearchHistory() {
       return ResponseEntity.ok(this.userSearchHistoryService.getAllUserSearchHistory());
    }
}
