package com.zcf.universe.controller.console;

import com.zcf.universe.pojo.LayUIMeun.LayUiMenuResult;
import com.zcf.universe.pojo.LayUIMeun.LayuiParentMenu;
import com.zcf.universe.service.LayUiMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuan
 * @date 2018/10/23 0023
 */
@RestController
public class LayUiMenu {
    @Autowired
    private LayUiMenuService service;

    @RequestMapping("LayUiMenus")
    public LayUiMenuResult menu() {
        List<LayuiParentMenu> menu = this.service.menu();
        LayUiMenuResult menuResult = new LayUiMenuResult();
        menuResult.setCode(0);
        menuResult.setMsg("返回成功");
        menuResult.setData(menu);
        return menuResult;

    }
}
