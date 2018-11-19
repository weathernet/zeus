package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.LayUIMeun.LayUiMenuResult;
import com.zcf.universe.common.LayUIMeun.LayuiParentMenu;
import com.zcf.universe.service.LayUI.LayUiMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * @author yuan
 * @date 2018/10/23 0023
 */
@RestController
public class LayUiMenu {
    @Autowired
    private LayUiMenuService service;

    @GetMapping("LayUiMenus")
    public LayUiMenuResult menu() {
        List<LayuiParentMenu> menu = this.service.menu();
        LayUiMenuResult menuResult = new LayUiMenuResult();
        menuResult.setCode(0);
        menuResult.setMsg("返回成功");
        menuResult.setData(menu);
        return menuResult;
    }

    @PostMapping("upload")
    public Map uploadImages(MultipartFile[] file){
        String customPath = "img/";
         Map map = FileUploadUtils.wangEditorImagesUpload(file, "", customPath);
        return map;
    }
}
