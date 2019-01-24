package ${basePackage}.service.layui;

import ${basePackage}.pojo.${modelNameUpperCamel};
import ${basePackage}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.common.layui.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
* @author ${author}
* @date ${date}
*/
@Service
public class LayUi${modelNameUpperCamel}Service{

    @Autowired
    private ${modelNameUpperCamel}Mapper LayUi${modelNameUpperCamel}Mapper;

    //新增
    public boolean add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return this.LayUi${modelNameUpperCamel}Mapper.insert(${modelNameLowerCamel}) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUi${modelNameUpperCamel}Mapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return this.LayUi${modelNameUpperCamel}Mapper.updateByPrimaryKeySelective(${modelNameLowerCamel}) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<${modelNameUpperCamel}> list = this.LayUi${modelNameUpperCamel}Mapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(${modelNameUpperCamel}.class);
        example.createCriteria().andLike("${modeListDetails[0].name}", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<${modelNameUpperCamel}> list = this.LayUi${modelNameUpperCamel}Mapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
