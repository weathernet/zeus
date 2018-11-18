package ${basePackage}.controller;

import ${basePackage}.common.utils.LayUiResult;
import ${basePackage}.common.utils.FileUploadUtils;
import ${basePackage}.pojo.${modelNameUpperCamel};
import ${basePackage}.service.LayUI.LayUi${modelNameUpperCamel}Service;
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
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class LayUi${modelNameUpperCamel}Controller {

    @Autowired
    private LayUi${modelNameUpperCamel}Service LayUi${modelNameLowerCamel}service;

    @RequestMapping("add")
    public boolean add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return this.LayUi${modelNameLowerCamel}service.add(${modelNameLowerCamel});
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUi${modelNameLowerCamel}service.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return this.LayUi${modelNameLowerCamel}service.update(${modelNameLowerCamel});
    }

    @RequestMapping("query")
    public LayUiResult query${modelNameUpperCamel}(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUi${modelNameLowerCamel}service.query(page,limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
        @RequestParam String keywords) {
        return this.LayUi${modelNameLowerCamel}service.search(page,limit,keywords);
    }

    @RequestMapping("upload")
    public Map UploadBrand(@RequestParam("file") MultipartFile file) throws FileNotFoundException{
        //String pathVal = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
        String pathVal = ResourceUtils.getURL("classpath:").getPath() + "static/";
        return FileUploadUtils.uploadLayUiImg(file, pathVal,"img/");
    }
}
