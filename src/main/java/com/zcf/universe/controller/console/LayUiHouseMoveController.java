package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HouseMove;
import com.zcf.universe.service.LayUI.LayUiHouseMoveService;
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
* Created by YuanQJ on 2018/11/14.
*/
@RestController
@RequestMapping("/house/move")
public class LayUiHouseMoveController {

    @Autowired
    private LayUiHouseMoveService LayUihouseMoveservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HouseMove houseMove) {
        return this.LayUihouseMoveservice.add(houseMove);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihouseMoveservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HouseMove houseMove) {
        return this.LayUihouseMoveservice.update(houseMove);
    }

    @RequestMapping("query")
    public LayUiResult queryHouseMove(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihouseMoveservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUihouseMoveservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file)  {
        return FileUploadUtils.uploadLayUiImg(file, "","house_move/");
    }
}
