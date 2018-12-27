package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.OwnerEntrust;
import com.zcf.universe.service.LayUI.LayUiOwnerEntrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@RestController
@RequestMapping("/owner/entrust")
public class LayUiOwnerEntrustController {

    @Autowired
    private LayUiOwnerEntrustService LayUiownerEntrustservice;

    @RequestMapping("add")
    public boolean add(@RequestBody OwnerEntrust ownerEntrust) {
        return this.LayUiownerEntrustservice.add(ownerEntrust);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUiownerEntrustservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody OwnerEntrust ownerEntrust) {
        return this.LayUiownerEntrustservice.update(ownerEntrust);
    }

    @RequestMapping("query")
    public LayUiResult queryOwnerEntrust(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUiownerEntrustservice.query(page, limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
                              @RequestParam String keywords) {
        return this.LayUiownerEntrustservice.search(page, limit, keywords);
    }

}
