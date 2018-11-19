package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.pojo.UserSearchHistory;
import com.zcf.universe.service.LayUI.LayUiUserSearchHistoryService;
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
* Created by YuanQJ on 2018/11/19.
*/
@RestController
@RequestMapping("/user/search/history")
public class LayUiUserSearchHistoryController {

    @Autowired
    private LayUiUserSearchHistoryService LayUiuserSearchHistoryservice;

    @RequestMapping("add")
    public boolean add(@RequestBody UserSearchHistory userSearchHistory) {
        return this.LayUiuserSearchHistoryservice.add(userSearchHistory);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUiuserSearchHistoryservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody UserSearchHistory userSearchHistory) {
        return this.LayUiuserSearchHistoryservice.update(userSearchHistory);
    }

    @RequestMapping("query")
    public LayUiResult queryUserSearchHistory(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUiuserSearchHistoryservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUiuserSearchHistoryservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) throws FileNotFoundException{
        //String pathVal = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
        String pathVal = ResourceUtils.getURL("classpath:").getPath() + "static/";
        return FileUploadUtils.uploadLayUiImg(file, pathVal,"img/");
    }
}
