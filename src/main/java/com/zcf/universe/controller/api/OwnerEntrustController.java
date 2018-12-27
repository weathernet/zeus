package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.OwnerEntrust;
import com.zcf.universe.service.OwnerEntrustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@RestController
@Api(value = "业主在线委托控制器", tags = {"业主在线委托接口"})
public class OwnerEntrustController {

    @Autowired
    private OwnerEntrustService ownerEntrustService;

    @ApiOperation(value = "新增在线委托")
    @PostMapping("ownerEntrust")
    public ResponseEntity<Void> addOwnerEntrust(OwnerEntrust ownerEntrust) {
        this.ownerEntrustService.addOwnerEntrust(ownerEntrust);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
