package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.FileUploadUtils;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.RepairCost;
import com.zcf.universe.service.LayUI.LayUiRepairCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by YuanQJ on 2018/11/13.
 */
@RestController
@RequestMapping("/repair/cost")
public class LayUiRepairCostController {

    @Autowired
    private LayUiRepairCostService LayUirepairCostservice;

    @RequestMapping("add")
    public boolean add(@RequestBody RepairCost repairCost) {
        return this.LayUirepairCostservice.add(repairCost);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUirepairCostservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody RepairCost repairCost) {
        return this.LayUirepairCostservice.update(repairCost);
    }

    @RequestMapping("query")
    public LayUiResult queryRepairCost(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUirepairCostservice.query(page, limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
                              @RequestParam String keywords) {
        return this.LayUirepairCostservice.search(page, limit, keywords);
    }

    @RequestMapping("queryById/{id}")
    public LayUiResult queryById(@PathVariable("id") Integer id, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUirepairCostservice.queryById(page, limit, id);
    }


    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        //String pathVal = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
        String pathVal = ResourceUtils.getURL("classpath:").getPath() + "static/";
        return FileUploadUtils.uploadLayUiImg(file, pathVal, "img/");
    }
}
