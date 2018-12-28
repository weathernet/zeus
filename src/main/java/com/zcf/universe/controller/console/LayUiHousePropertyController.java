package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HouseProperty;
import com.zcf.universe.service.LayUI.LayUiHousePropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author 袁齐吉
 * @date 2018/12/28
 */
@RestController
@RequestMapping("/house/property")
public class LayUiHousePropertyController {

    @Autowired
    private LayUiHousePropertyService LayUihousePropertyservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HouseProperty houseProperty) {
        return this.LayUihousePropertyservice.add(houseProperty);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihousePropertyservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HouseProperty houseProperty) {
        return this.LayUihousePropertyservice.update(houseProperty);
    }

    @RequestMapping("query")
    public LayUiResult queryHouseProperty(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihousePropertyservice.query(page, limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
                              @RequestParam String keywords) {
        return this.LayUihousePropertyservice.search(page, limit, keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) {
        return FileUploadUtils.uploadLayUiImg(file, "", "img/");
    }
}
