package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.pojo.OwnerNews;
import com.zcf.universe.service.LayUI.LayUiOwnerNewsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.ResourceUtils;
import java.io.FileNotFoundException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/**
* Created by YuanQJ on 2018/11/22.
*/
@RestController
@RequestMapping("/owner/news")
public class LayUiOwnerNewsController {

    @Autowired
    private LayUiOwnerNewsService LayUiownerNewsservice;

    @RequestMapping("add")
    public boolean add(@RequestBody OwnerNews ownerNews) {
        return this.LayUiownerNewsservice.add(ownerNews);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUiownerNewsservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody OwnerNews ownerNews) {
        return this.LayUiownerNewsservice.update(ownerNews);
    }

    @RequestMapping("query")
    public LayUiResult queryOwnerNews(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUiownerNewsservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUiownerNewsservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) throws FileNotFoundException{
        //String pathVal = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
        String pathVal = ResourceUtils.getURL("classpath:").getPath() + "static/";
        return FileUploadUtils.uploadLayUiImg(file, pathVal,"img/");
    }
}
