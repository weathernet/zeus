package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HomeTravel;
import com.zcf.universe.service.LayUI.LayUiHomeTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* @author 袁齐吉
* @date 2018/12/28
*/
@RestController
@RequestMapping("/home/travel")
public class LayUiHomeTravelController {

    @Autowired
    private LayUiHomeTravelService LayUihomeTravelservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HomeTravel homeTravel) {
        return this.LayUihomeTravelservice.add(homeTravel);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihomeTravelservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HomeTravel homeTravel) {
        return this.LayUihomeTravelservice.update(homeTravel);
    }

    @RequestMapping("query")
    public LayUiResult queryHomeTravel(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihomeTravelservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUihomeTravelservice.search(page,limit,keywords);
    }


}
