package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.UserCollection;
import com.zcf.universe.service.UserCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ApiOperation(value = "查看当前房源用户是否已收藏")
    @GetMapping("Collection")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "houseId", value = "房源ID", required = true, dataType = "Integer")

    })
    public ResponseEntity<Boolean> checkCollection(
            @RequestParam("userId") Integer userId,
            @RequestParam("houseId") Integer houseId
    ) {
        return ResponseEntity.ok(this.userCollectionService.checkCollection(userId, houseId));
    }

    @ApiOperation(value = "删除收藏的房源")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "houseId", value = "房源ID", required = true, dataType = "Integer")
    })
    @PostMapping("Collection")
    public ResponseEntity<Void> deleteUserCollection(
            @RequestParam("userId") Integer userId,
            @RequestParam("houseId") Integer houseId
    ) {
        this.userCollectionService.deleteUserCollection(userId, houseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
