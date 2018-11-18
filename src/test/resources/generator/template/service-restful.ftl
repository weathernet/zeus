package ${basePackage}.service;

import ${basePackage}.pojo.${modelNameUpperCamel};
import ${basePackage}.mapper.${modelNameUpperCamel}Mapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import java.util.List;
/**
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}Service{

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}mapper;

    //新增
    public void add${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        boolean flag = this.${modelNameLowerCamel}mapper.insert(${modelNameLowerCamel}) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void delete${modelNameUpperCamel}(Integer id) {
        boolean flag = this.${modelNameLowerCamel}mapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void update${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        boolean flag =this.${modelNameLowerCamel}mapper.updateByPrimaryKeySelective(${modelNameLowerCamel}) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<${modelNameUpperCamel}> getAll${modelNameUpperCamel}() {
        List<${modelNameUpperCamel}> list = this.${modelNameLowerCamel}mapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public ${modelNameUpperCamel} get${modelNameUpperCamel}(Integer id){
        ${modelNameUpperCamel} ${modelNameUpperCamel} = this.${modelNameLowerCamel}mapper.selectByPrimaryKey(id);
        if (${modelNameUpperCamel} == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return ${modelNameUpperCamel};
    }

    //字段搜索
     public List<${modelNameUpperCamel}> search${modelNameUpperCamel}(String keywords) {
        Example example = new Example(${modelNameUpperCamel}.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<${modelNameUpperCamel}> list = this.${modelNameLowerCamel}mapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
