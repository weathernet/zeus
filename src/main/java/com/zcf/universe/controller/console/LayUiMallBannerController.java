package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.MallBanner;
import com.zcf.universe.service.LayUI.LayUiMallBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
/**
* Created by YuanQJ on 2018/11/18.
*/
@RestController
@RequestMapping("/mall/banner")
public class LayUiMallBannerController {

    @Autowired
    private LayUiMallBannerService LayUimallBannerservice;

    @RequestMapping("add")
    public boolean add(@RequestBody MallBanner mallBanner) {
        return this.LayUimallBannerservice.add(mallBanner);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUimallBannerservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody MallBanner mallBanner) {
        return this.LayUimallBannerservice.update(mallBanner);
    }

    @RequestMapping("query")
    public LayUiResult queryMallBanner(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUimallBannerservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUimallBannerservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file)  {
        return FileUploadUtils.uploadLayUiImg(file, "","mall_banner/");
    }
}
