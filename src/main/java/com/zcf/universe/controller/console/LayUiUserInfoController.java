package com.zcf.universe.controller.console;


import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.UserInfo;
import com.zcf.universe.service.LayUI.LayUiUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
* Created by YuanQJ on 2018/11/05.
*/
@RestController
@RequestMapping("/user/info")
public class LayUiUserInfoController {

    @Autowired
    private LayUiUserInfoService LayUiuserInfoservice;

    @RequestMapping("add")
    public boolean add(@RequestBody UserInfo userInfo) {
        return this.LayUiuserInfoservice.add(userInfo);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUiuserInfoservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody UserInfo userInfo) {
        return this.LayUiuserInfoservice.update(userInfo);
    }

    @RequestMapping("query")
    public LayUiResult queryUserInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUiuserInfoservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUiuserInfoservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){
        String pathVal = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
        return FileUploadUtils.uploadLayUiImg(file, pathVal,"img/");
    }

}
