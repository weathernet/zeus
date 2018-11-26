package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.OwnerVideo;
import com.zcf.universe.service.OwnerVideoService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

/**
* Created by YuanQJ on 2018/11/22.
*/
@RestController
@Api(value = "业主视频控制器", tags = {"业主视频接口"})
public class OwnerVideoController {

    @Autowired
    private OwnerVideoService ownerVideoService;

    @ApiOperation(value = "新增")
    @PostMapping("ownerVideo")
    public ResponseEntity<Void> addOwnerVideo(OwnerVideo ownerVideo) {
        this.ownerVideoService.addOwnerVideo(ownerVideo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("ownerVideo/{id}")
    public ResponseEntity<Void> deleteOwnerVideo(@PathVariable Integer id) {
        this.ownerVideoService.deleteOwnerVideo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改")
    @PutMapping("ownerVideo")
    public ResponseEntity<Void> updateOwnerVideo(OwnerVideo ownerVideo) {
        this.ownerVideoService.updateOwnerVideo(ownerVideo);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("ownerVideo/{id}")
    public ResponseEntity<OwnerVideo> getOwnerVideo(@PathVariable Integer id) {
        return ResponseEntity.ok(this.ownerVideoService.getOwnerVideo(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("OwnerVideo")
    public  ResponseEntity<List<OwnerVideo>> getAllOwnerVideo() {
       return ResponseEntity.ok(this.ownerVideoService.getAllOwnerVideo());
    }
}
