package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.OwnerEntrustMapper;
import com.zcf.universe.pojo.OwnerEntrust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author YuanQJ
* @date 2018/12/25
*/
@Service
public class OwnerEntrustService {

    @Autowired
    private OwnerEntrustMapper ownerEntrustmapper;

    //新增
    public void addOwnerEntrust(OwnerEntrust ownerEntrust) {
        int count = this.ownerEntrustmapper.insertSelective(ownerEntrust);
        if(count != 1){
             throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }
    }
//    //查询所有
//    public List<OwnerEntrust> getAllOwnerEntrust() {
//        List<OwnerEntrust> list = this.ownerEntrustmapper.selectAll();
//       if(CollectionUtils.isEmpty(list)){
//            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
//        }
//        return list;
//    }
//
//    //查询单个
//    public OwnerEntrust getOwnerEntrust(Integer id){
//        OwnerEntrust OwnerEntrust = this.ownerEntrustmapper.selectByPrimaryKey(id);
//        if (OwnerEntrust == null) {
//            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
//        }
//        return OwnerEntrust;
//    }

}
