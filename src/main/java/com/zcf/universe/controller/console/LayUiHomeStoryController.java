package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HomeStory;
import com.zcf.universe.service.LayUI.LayUiHomeStoryService;
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
@RequestMapping("/home/story")
public class LayUiHomeStoryController {

    @Autowired
    private LayUiHomeStoryService LayUihomeStoryservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HomeStory homeStory) {
        return this.LayUihomeStoryservice.add(homeStory);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihomeStoryservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HomeStory homeStory) {
        return this.LayUihomeStoryservice.update(homeStory);
    }

    @RequestMapping("query")
    public LayUiResult queryHomeStory(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihomeStoryservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUihomeStoryservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) throws FileNotFoundException{
        String pathVal = ResourceUtils.getURL("classpath:").getPath() + "static/start/";
        return FileUploadUtils.uploadLayUiImg(file, pathVal,"img/");
    }
}
