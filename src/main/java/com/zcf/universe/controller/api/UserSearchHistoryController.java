package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.UserSearchHistory;
import com.zcf.universe.service.UserSearchHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/19.
*/
@RestController
@Api(value = "用户搜索历史控制器", tags = {"用户搜索历史接口"})
public class UserSearchHistoryController {

    @Autowired
    private UserSearchHistoryService userSearchHistoryService;

    @ApiOperation(value = "新增历史搜索")
    @PostMapping("userSearchHistory")
    public ResponseEntity<Void> addUserSearchHistory(UserSearchHistory userSearchHistory) {
        this.userSearchHistoryService.addUserSearchHistory(userSearchHistory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "清除所有历史记录")
    @DeleteMapping("userSearchHistory/{id}")
    public ResponseEntity<Void> deleteUserSearchHistory(@PathVariable Integer id) {
        this.userSearchHistoryService.deleteUserSearchHistory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @ApiOperation(value = "获取当前用户的搜索历史")
    @GetMapping("userSearchHistory/{id}")
    public ResponseEntity <List<UserSearchHistory>> getUserSearchHistory(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userSearchHistoryService.getUserSearchHistory(id));
    }
}
