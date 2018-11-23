package com.zcf.universe.service;

import com.zcf.universe.pojo.OwnerCase;
import com.zcf.universe.mapper.OwnerCaseMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/22.
 */
@Service
public class OwnerCaseService{

    @Autowired
    private OwnerCaseMapper ownerCasemapper;

    //新增
    public void addOwnerCase(OwnerCase ownerCase) {
        int count = this.ownerCasemapper.insert(ownerCase);
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteOwnerCase(Integer id) {
        int count = this.ownerCasemapper.deleteByPrimaryKey(id);
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateOwnerCase(OwnerCase ownerCase) {
        int count = this.ownerCasemapper.updateByPrimaryKeySelective(ownerCase);
         if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<OwnerCase> getAllOwnerCase() {
        List<OwnerCase> list = this.ownerCasemapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public OwnerCase getOwnerCase(Integer id){
        OwnerCase OwnerCase = this.ownerCasemapper.selectByPrimaryKey(id);
        if (OwnerCase == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return OwnerCase;
    }

    //字段搜索
     public List<OwnerCase> searchOwnerCase(String keywords) {
        Example example = new Example(OwnerCase.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<OwnerCase> list = this.ownerCasemapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
