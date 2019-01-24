package com.zcf.universe.controller.api;


import com.zcf.universe.pojo.HouseProperty;
import com.zcf.universe.service.HousePropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 袁齐吉
 * @date 2018/12/28
 */
@RestController
@Api(value = "房产出售控制器", tags = {"房产出售接口"})
public class HousePropertyController {

    @Autowired
    private HousePropertyService housePropertyService;

    @ApiOperation(value = "获取该城市所有出售的房产")
    @GetMapping("HouseProperty")
    public ResponseEntity<List<HouseProperty>> getAllHouseProperty(String city) {
        return ResponseEntity.ok(this.housePropertyService.searchHousePropertyByCity(city));
    }

    @ApiOperation(value = "根据类型获取房产")
    @GetMapping("HousePropertyType")
    public ResponseEntity<List<HouseProperty>> getAllHousePropertyByStatus(String city, String type) {
        return ResponseEntity.ok(this.housePropertyService.getAllHousePropertyByStatus(city, type));
    }

    @ApiOperation(value = "搜索房产", notes = "城市不可为空")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "key", value = "搜索关键字", dataType = "String"),
            @ApiImplicitParam(name = "city", value = "所在城市", dataType = "String"),
            @ApiImplicitParam(name = "min", value = "最小金额", dataType = "Integer"),
            @ApiImplicitParam(name = "max", value = "最大金额", dataType = "Integer"),
            @ApiImplicitParam(name = "group", value = "排序的字段", dataType = "String"),
            @ApiImplicitParam(name = "desc", value = "正序倒叙", dataType = "Boolean")
    })
    @GetMapping("searchHouseProperty")
    public ResponseEntity<List<HouseProperty>> searchHouses(
            @RequestParam String key,
            @RequestParam String city,
            Integer min,
            Integer max,
            String group,
            @RequestParam(defaultValue = "true") boolean desc

    ) {
        return ResponseEntity.ok(this.housePropertyService.searchHouses(key, city, min, max, group, desc));
    }

    @ApiOperation(value = "搜索類型房产", notes = "城市不可为空")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "type", value = "分組類型", dataType = "String"),
            @ApiImplicitParam(name = "city", value = "所在城市", dataType = "String"),
            @ApiImplicitParam(name = "min", value = "最小金额", dataType = "Integer"),
            @ApiImplicitParam(name = "max", value = "最大金额", dataType = "Integer"),
            @ApiImplicitParam(name = "group", value = "排序的字段", dataType = "String"),
            @ApiImplicitParam(name = "desc", value = "正序倒叙", dataType = "Boolean")
    })
    @GetMapping("searchHousesByType")
    public ResponseEntity<List<HouseProperty>> searchHousesByType(
            @RequestParam String type,
            @RequestParam String city,
            Integer min,
            Integer max,
            String group,
            @RequestParam(defaultValue = "true") boolean desc

    ) {
        return ResponseEntity.ok(this.housePropertyService.searchHouses(type, city, min, max, group, desc));
    }

}
