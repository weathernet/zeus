package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.MallGroup;
import com.zcf.universe.service.MallGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by YuanQJ on 2018/11/18.
*/
@RestController
@Api(value = "商城分类管理控制器", tags = {"商城分类管理接口"})
public class MallGroupController {

    @Autowired
    private MallGroupService mallGroupService;


    @ApiOperation(value = "根据服务获取所有分类")
    @PostMapping("MallGroup")
    public  ResponseEntity<List<MallGroup>> getAllMallGroupById(Integer byid) {
        return ResponseEntity.ok(this.mallGroupService.searchMallGroupById(byid));
    }

    @ApiOperation(value = "获取所有热门分类")
    @GetMapping("MallHotGroup")
    public  ResponseEntity<List<MallGroup>> getAllMallGroupByHot() {
        return ResponseEntity.ok(this.mallGroupService.searchMallGroupByHot());
    }

    @ApiOperation(value = "新增")
    @PostMapping("mallGroup")
    public ResponseEntity<Void> addMallGroup(MallGroup mallGroup) {
        this.mallGroupService.addMallGroup(mallGroup);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mallGroup/{id}")
    public ResponseEntity<Void> deleteMallGroup(@PathVariable Integer id) {
        this.mallGroupService.deleteMallGroup(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("mallGroup")
    public ResponseEntity<Void> updateMallGroup(MallGroup mallGroup) {
        this.mallGroupService.updateMallGroup(mallGroup);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("mallGroup/{id}")
    public ResponseEntity<MallGroup> getMallGroup(@PathVariable Integer id) {
        return ResponseEntity.ok(this.mallGroupService.getMallGroup(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("MallGroup")
    public  ResponseEntity<List<MallGroup>> getAllMallGroup() {
       return ResponseEntity.ok(this.mallGroupService.getAllMallGroup());
    }
}
