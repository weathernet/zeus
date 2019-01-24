package ${basePackage}.controller.api;


import ${basePackage}.pojo.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

/**
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping("${modelNameLowerCamel}")
@Api(value = "${modelNameUpperCamel}控制器", tags = {"${modelNameUpperCamel}接口"})
public class ${modelNameUpperCamel}Controller {

    @Autowired
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Void> add${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        this.${modelNameLowerCamel}Service.add${modelNameUpperCamel}(${modelNameLowerCamel});
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete${modelNameUpperCamel}ById(@PathVariable Integer id) {
        this.${modelNameLowerCamel}Service.delete${modelNameUpperCamel}ById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "修改")
    @PutMapping
    public ResponseEntity<Void> update${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        this.${modelNameLowerCamel}Service.update${modelNameUpperCamel}(${modelNameLowerCamel});
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "获取单个")
    @GetMapping("/{id}")
    public ResponseEntity<${modelNameUpperCamel}> get${modelNameUpperCamel}(@PathVariable Integer id) {
        return ResponseEntity.ok(this.${modelNameLowerCamel}Service.get${modelNameUpperCamel}(id));
    }

    @ApiOperation(value = "获取所有")
    @GetMapping
    public  ResponseEntity<List<${modelNameUpperCamel}>> getAll${modelNameUpperCamel}() {
       return ResponseEntity.ok(this.${modelNameLowerCamel}Service.getAll${modelNameUpperCamel}());
    }
}
