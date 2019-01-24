package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.pojo.MallGoods;
import com.zcf.universe.service.LayUI.LayUiMallGoodsService;
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
* Created by YuanQJ on 2018/11/18.
*/
@RestController
@RequestMapping("/mall/goods")
public class LayUiMallGoodsController {

    @Autowired
    private LayUiMallGoodsService LayUimallGoodsservice;

    @RequestMapping("add")
    public boolean add(@RequestBody MallGoods mallGoods) {
        return this.LayUimallGoodsservice.add(mallGoods);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUimallGoodsservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody MallGoods mallGoods) {
        return this.LayUimallGoodsservice.update(mallGoods);
    }

    @RequestMapping("query")
    public LayUiResult queryMallGoods(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUimallGoodsservice.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUimallGoodsservice.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file)  {
        return FileUploadUtils.uploadLayUiImg(file, "","mall_goods/");
    }
}
