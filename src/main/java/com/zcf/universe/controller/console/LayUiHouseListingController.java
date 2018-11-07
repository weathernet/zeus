package com.zcf.universe.controller.console;


import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HouseListing;
import com.zcf.universe.service.LayUI.LayUiHouseListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Map;

/**
* Created by YuanQJ on 2018/11/06.
*/
@RestController
@RequestMapping("/house/listing")
public class LayUiHouseListingController {

    @Autowired
    private LayUiHouseListingService LayUihouseListingservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HouseListing houseListing) {
        return this.LayUihouseListingservice.add(houseListing);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihouseListingservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HouseListing houseListing) {
        return this.LayUihouseListingservice.update(houseListing);
    }

    @RequestMapping("query")
    public LayUiResult queryHouseListing(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihouseListingservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
                              @RequestParam String keywords) {
        return this.LayUihouseListingservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        String pathVal = ResourceUtils.getURL("classpath:").getPath() + "static/";
        return FileUploadUtils.uploadLayUiImg(file, pathVal,"img/");
    }
}
