package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.OwnerAdvantage;
import com.zcf.universe.service.LayUI.LayUiOwnerAdvantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@RestController
@RequestMapping("/owner/advantage")
public class LayUiOwnerAdvantageController {

    @Autowired
    private LayUiOwnerAdvantageService LayUiownerAdvantageservice;
    @RequestMapping("update")
    public boolean update(@RequestBody OwnerAdvantage ownerAdvantage) {
        return this.LayUiownerAdvantageservice.update(ownerAdvantage);
    }
    @RequestMapping("query")
    public LayUiResult queryOwnerAdvantage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUiownerAdvantageservice.query(page, limit);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) {
        return FileUploadUtils.uploadLayUiImg(file, "", "owner_advantage/");
    }
}
