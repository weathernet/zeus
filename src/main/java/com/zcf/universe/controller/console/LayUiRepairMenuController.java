package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.RepairMenu;
import com.zcf.universe.service.LayUI.LayUiRepairMenuService;
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
* Created by YuanQJ on 2018/11/12.
*/
@RestController
@RequestMapping("/repair/menu")
public class LayUiRepairMenuController {

    @Autowired
    private LayUiRepairMenuService LayUirepairMenuservice;

    @RequestMapping("add")
    public boolean add(@RequestBody RepairMenu repairMenu) {
        return this.LayUirepairMenuservice.add(repairMenu);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUirepairMenuservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody RepairMenu repairMenu) {
        return this.LayUirepairMenuservice.update(repairMenu);
    }

    @RequestMapping("query")
    public LayUiResult queryRepairMenu(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUirepairMenuservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUirepairMenuservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file){
        return FileUploadUtils.uploadLayUiImg(file, "","repair/");
    }
}
