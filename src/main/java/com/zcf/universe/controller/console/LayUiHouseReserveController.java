package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HouseReserve;
import com.zcf.universe.service.LayUI.LayUiHouseReserveService;
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
* Created by YuanQJ on 2018/11/09.
*/
@RestController
@RequestMapping("/house/reserve")
public class LayUiHouseReserveController {

    @Autowired
    private LayUiHouseReserveService LayUihouseReserveservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HouseReserve houseReserve) {
        return this.LayUihouseReserveservice.add(houseReserve);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihouseReserveservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HouseReserve houseReserve) {
        return this.LayUihouseReserveservice.update(houseReserve);
    }

    @RequestMapping("query")
    public LayUiResult queryHouseReserve(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihouseReserveservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUihouseReserveservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) throws FileNotFoundException{
        //String pathVal = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
        String pathVal = ResourceUtils.getURL("classpath:").getPath() + "static/";
        return FileUploadUtils.uploadLayUiImg(file, pathVal,"img/");
    }
}
