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
            @ApiImplicitParam(name = "city", value = "所在城市", dataType = "String")
    })
    @GetMapping("searchHouse")
    public ResponseEntity<List<HouseListing>> getHouseListings(
            @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows,
            @RequestParam(defaultValue = "20") String sortBy, @RequestParam(defaultValue = "true") Boolean desc, @RequestParam String key,
            @RequestParam(defaultValue = "北京") String city
    ) {
        return ResponseEntity.ok(this.houseListingService.getHouseListings(page, rows, sortBy, desc, key, city));
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
}
