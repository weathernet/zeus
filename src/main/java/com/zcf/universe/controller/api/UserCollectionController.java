package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.UserCollection;
import com.zcf.universe.service.UserCollectionService;
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
@Api(value = "用户收藏控制器", tags = {"用户收藏控制器"})
public class UserCollectionController {

    @Autowired
    private UserCollectionService userCollectionService;

    @ApiOperation(value = "新增")
    @PostMapping("userCollection")
    public ResponseEntity addUserCollection(UserCollection userCollection) {
        this.userCollectionService.addUserCollection(userCollection);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("userCollection/{id}")
    public ResponseEntity<Void> deleteUserCollection(@PathVariable Integer id) {
        this.userCollectionService.deleteUserCollection(id);
        return ResponseEntity.ok(null);
    }


    @ApiOperation(value = "获取单个")
    @GetMapping("userCollection/{id}")
    public ResponseEntity<UserCollection> getUserCollection(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userCollectionService.getUserCollection(id));
    }

    @ApiOperation(value = "获取当前用戶所有的收藏")
    @GetMapping("UserCollection")
    public ResponseEntity<List<UserCollection>> getAllUserCollection(Integer id) {
        return ResponseEntity.ok(this.userCollectionService.getAllUserCollection(id));
    }
}
