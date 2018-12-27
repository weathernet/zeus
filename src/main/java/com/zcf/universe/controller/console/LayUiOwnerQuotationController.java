package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.OwnerQuotation;
import com.zcf.universe.service.LayUI.LayUiOwnerQuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* @author YuanQJ
* @date 2018/12/26
*/
@RestController
@RequestMapping("/owner/quotation")
public class LayUiOwnerQuotationController {

    @Autowired
    private LayUiOwnerQuotationService LayUiownerQuotationservice;

    @RequestMapping("add")
    public boolean add(@RequestBody OwnerQuotation ownerQuotation) {
        return this.LayUiownerQuotationservice.add(ownerQuotation);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUiownerQuotationservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody OwnerQuotation ownerQuotation) {
        return this.LayUiownerQuotationservice.update(ownerQuotation);
    }

    @RequestMapping("query")
    public LayUiResult queryOwnerQuotation(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUiownerQuotationservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUiownerQuotationservice.search(page,limit,keywords);
    }


}
