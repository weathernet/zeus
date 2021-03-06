package com.zcf.universe.controller.api;

import com.zcf.universe.pojo.HouseLabel;
import com.zcf.universe.pojo.HouseListing;
import com.zcf.universe.service.HouseListingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author yuan
 * @date 2018/11/6 0006
 */
@RestController
@Api(value = "房源控制器", tags = {"房源控制器"})
public class HouseListingController {

    @Autowired
    private HouseListingService houseListingService;

    @ApiOperation(value = "查询房源", notes = "城市不可为空")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "page", value = "页", dataType = "int"),
            @ApiImplicitParam(name = "rows", value = "行", dataType = "int"),
            @ApiImplicitParam(name = "sortBy", value = "排序关键字", dataType = "String"),
            @ApiImplicitParam(name = "desc", value = "正序倒叙", dataType = "boolean"),
            @ApiImplicitParam(name = "key", value = "搜索关键字", dataType = "String"),
            @ApiImplicitParam(name = "city", value = "所在城市", dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "用户的主键", dataType = "String")
    })
    @GetMapping("getHouse")
    public ResponseEntity<List<HouseListing>> getHouseListings(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            @RequestParam String sortBy,
            @RequestParam(defaultValue = "true") Boolean desc,
            @RequestParam String key,
            @RequestParam String city,
            @RequestParam Integer userId
    ) {
        return ResponseEntity.ok(this.houseListingService.getHouseListings(page, rows, sortBy, desc, key, city, userId));
    }

    @ApiOperation(value = "搜索房源", notes = "城市不可为空")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "key", value = "搜索关键字", dataType = "String"),
            @ApiImplicitParam(name = "city", value = "所在城市", dataType = "String"),
            @ApiImplicitParam(name = "min", value = "最小金额", dataType = "Integer"),
            @ApiImplicitParam(name = "max", value = "最大金额", dataType = "Integer"),
            @ApiImplicitParam(name = "group", value = "排序的字段", dataType = "String"),
            @ApiImplicitParam(name = "desc", value = "正序倒叙", dataType = "Boolean")
    })
    @GetMapping("searchHouses")
    public ResponseEntity<List<HouseListing>> searchHouses(
            @RequestParam String key,
            @RequestParam String city,
            Integer min,
            Integer max,
            String group,
            @RequestParam(defaultValue = "true") boolean desc

    ) {
        return ResponseEntity.ok(this.houseListingService.searchHouses(key, city, min, max,group,desc));
    }

    @ApiOperation(value = "发布房源")
    @PostMapping("houseListing")
    public ResponseEntity<Void> addHouseListing(HouseListing houseListing) {
        this.houseListingService.addHouseListing(houseListing);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改房源的信息")
    @PutMapping("houseListing/{id}")
    public ResponseEntity<Void> updateHouseListing(@PathVariable() Integer id, HouseListing houseListing) {
        this.houseListingService.updateHouseListing(id, houseListing);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "当前房源的回显")
    @GetMapping("houseListing/{id}")
    public ResponseEntity<HouseListing> getHouseListing(@PathVariable() Integer id) {
        return ResponseEntity.ok(this.houseListingService.getHouseListing(id));
    }

    @GetMapping("houseLabel")
    @ApiOperation(value = "显示所有的标签")
    public ResponseEntity<List<HouseLabel>> getHouseLabel() {
        return ResponseEntity.ok(this.houseListingService.getHouseLabel());
    }

    @ApiOperation(value = "地图找房")
    @GetMapping("mapLookingForRoom")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "longitude", value = "经度", dataType = "String"),
            @ApiImplicitParam(name = "latitude", value = "纬度", dataType = "String"),
            @ApiImplicitParam(name = "range", value = "范围", dataType = "int")

    })
    public ResponseEntity<List<HouseListing>> mapLookingForRoom(@RequestParam String longitude, @RequestParam String latitude, @RequestParam Integer range) {
        return ResponseEntity.ok(this.houseListingService.mapLookingForRoom(longitude, latitude, range));
    }

    @ApiOperation(value = "房屋估价")
    @GetMapping("houseAppraisal")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "city", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "villageName", value = "小区名称", dataType = "String"),
            @ApiImplicitParam(name = "buildingNumber", value = "楼栋号", dataType = "String"),
            @ApiImplicitParam(name = "numberOfLivingRooms", value = "居室数量", dataType = "String"),
            @ApiImplicitParam(name = "coveredArea", value = "建筑总面积", dataType = "String"),
            @ApiImplicitParam(name = "orientation", value = "房屋朝向(选填)", dataType = "String"),
            @ApiImplicitParam(name = "decorateADegree", value = "装修程度", dataType = "String"),
            @ApiImplicitParam(name = "theLeaseTime", value = "可出租时长", dataType = "String")
    })
    public ResponseEntity houseAppraisal(
            @RequestParam("city") String city,
            @RequestParam("villageName") String villageName,
            @RequestParam("buildingNumber") String buildingNumber,
            @RequestParam("numberOfLivingRooms") String numberOfLivingRooms,
            @RequestParam("coveredArea") String coveredArea,
            @RequestParam("orientation") String orientation,
            @RequestParam("decorateADegree") String decorateADegree,
            @RequestParam("theLeaseTime") @NotBlank(message = "theLeaseTime 不能为空") String theLeaseTime
    ) {
        //TODO  房屋估价接口
        return ResponseEntity.ok().build();
    }

}
