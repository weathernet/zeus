package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.OwnerPhone;
import com.zcf.universe.service.OwnerPhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@RestController
@Api(value = "业主电话咨询控制器", tags = {"业主电话咨询接口"})
public class OwnerPhoneController {
    @Autowired
    private OwnerPhoneService ownerPhoneService;

    @ApiOperation(value = "获取单个")
    @GetMapping("ownerPhone/{id}")
    public ResponseEntity<OwnerPhone> getOwnerPhone(@PathVariable Integer id) {
        return ResponseEntity.ok(this.ownerPhoneService.getOwnerPhone(id));
    }

}
