package com.zcf.universe.controller.console;

import com.zcf.universe.common.LayUIMeun.LayUiMenuResult;
import com.zcf.universe.common.LayUIMeun.LayuiParentMenu;
import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.service.LayUI.LayUiMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author yuan
 * @date 2018/10/23 0023
 */
@Controller
public class LayUiMenu {

    @Autowired
    private LayUiMenuService service;

    @GetMapping("LayUiMenus")
    @ResponseBody
    public LayUiMenuResult menu() {
        List<LayuiParentMenu> menu = this.service.menu();
        LayUiMenuResult menuResult = new LayUiMenuResult();
        menuResult.setCode(0);
        menuResult.setMsg("返回成功");
        menuResult.setData(menu);
        return menuResult;
    }

    @PostMapping("upload")
    @ResponseBody
    public Map uploadImages(MultipartFile[] file) {
        String customPath = "img/";
        Map map = FileUploadUtils.wangEditorImagesUpload(file, "", customPath);
        return map;
    }

    @GetMapping("/index")
    public String index() {
        return "login";
    }

    @GetMapping("/test")
    public String Test() {
        return "Test";
    }

    @GetMapping("/webSocket")
    public String webSocket() {
        return "websocket";
    }

    @GetMapping("/map")
    public String map() {
        return "map";
    }
}
