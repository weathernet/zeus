package ${basePackage}.web;

import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@RestController
@Api(value = "首页管理控制器", tags = {"首页管理接口"})
public class ${modelNameUpperCamel}Controller {

    @Autowired
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @ApiOperation(value = "新增")
    @PostMapping("${modelNameLowerCamel}")
    public ResponseEntity<Void> add${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        this.${modelNameLowerCamel}Service.add${modelNameUpperCamel}(${modelNameLowerCamel});
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("${modelNameLowerCamel}/{id}")
    public ResponseEntity<Void> delete${modelNameUpperCamel}(@PathVariable Integer id) {
        this.${modelNameLowerCamel}Service.delete${modelNameUpperCamel}(id);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("${modelNameLowerCamel}")
    public ResponseEntity<Void> update${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        this.${modelNameLowerCamel}Service.update${modelNameUpperCamel}(${modelNameLowerCamel});
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("${modelNameLowerCamel}/{id}")
    public ResponseEntity<${modelNameUpperCamel}> get${modelNameUpperCamel}(@PathVariable Integer id) {
        return ResponseEntity.ok(this.${modelNameLowerCamel}Service.get${modelNameUpperCamel}(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("${modelNameUpperCamel}")
    public  ResponseEntity<List<${modelNameUpperCamel}>> getAll${modelNameUpperCamel}() {
       return ResponseEntity.ok(this.${modelNameLowerCamel}Service.getAll${modelNameUpperCamel}());
    }
}
