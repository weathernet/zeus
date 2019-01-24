package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.pojo.OwnerCase;
import com.zcf.universe.service.LayUI.LayUiOwnerCaseService;
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
@RequestMapping("/owner/case")
public class LayUiOwnerCaseController {

    @Autowired
    private LayUiOwnerCaseService LayUiownerCaseservice;

    @RequestMapping("add")
    public boolean add(@RequestBody OwnerCase ownerCase) {
        return this.LayUiownerCaseservice.add(ownerCase);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUiownerCaseservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody OwnerCase ownerCase) {
        return this.LayUiownerCaseservice.update(ownerCase);
    }

    @RequestMapping("query")
    public LayUiResult queryOwnerCase(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUiownerCaseservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUiownerCaseservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) throws FileNotFoundException{
        return FileUploadUtils.uploadLayUiImg(file,"","owner_case");
    }
}
