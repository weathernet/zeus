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

}
