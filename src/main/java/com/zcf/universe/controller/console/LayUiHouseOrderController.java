package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HouseOrder;
import com.zcf.universe.service.LayUI.LayUiHouseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* @author YuanQJ
* @date 2018/12/27
*/
@RestController
@RequestMapping("/house/order")
public class LayUiHouseOrderController {

    @Autowired
    private LayUiHouseOrderService LayUihouseOrderservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HouseOrder houseOrder) {
        return this.LayUihouseOrderservice.add(houseOrder);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihouseOrderservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HouseOrder houseOrder) {
        return this.LayUihouseOrderservice.update(houseOrder);
    }

    @RequestMapping("query")
    public LayUiResult queryHouseOrder(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihouseOrderservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUihouseOrderservice.search(page,limit,keywords);
    }
}
