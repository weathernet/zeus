package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HomeBanner;
import com.zcf.universe.service.LayUI.LayUiHomeBannerService;
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
 * Created by YuanQJ on 2018/11/07.
 */
@RestController
@RequestMapping("/home/banner")
public class LayUiHomeBannerController {

    @Autowired
    private LayUiHomeBannerService LayUihomeBannerservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HomeBanner homeBanner) {
        return this.LayUihomeBannerservice.add(homeBanner);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihomeBannerservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HomeBanner homeBanner) {
        return this.LayUihomeBannerservice.update(homeBanner);
    }

    @RequestMapping("query")
    public LayUiResult queryHomeBanner(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihomeBannerservice.query(page, limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
                              @RequestParam String keywords) {
        return this.LayUihomeBannerservice.search(page, limit, keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) {
        return FileUploadUtils.uploadLayUiImg(file, "", "banner/");
    }
}
