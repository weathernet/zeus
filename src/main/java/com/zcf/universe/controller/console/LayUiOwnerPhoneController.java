package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.OwnerPhone;
import com.zcf.universe.service.LayUI.LayUiOwnerPhoneService;
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
@RequestMapping("/owner/phone")
public class LayUiOwnerPhoneController {

    @Autowired
    private LayUiOwnerPhoneService LayUiownerPhoneservice;

    @RequestMapping("update")
    public boolean update(@RequestBody OwnerPhone ownerPhone) {
        return this.LayUiownerPhoneservice.update(ownerPhone);
    }

    @RequestMapping("query")
    public LayUiResult queryOwnerPhone(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUiownerPhoneservice.query(page, limit);
    }


}
