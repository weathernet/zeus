package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.MoveDetailsMapper;
import com.zcf.universe.pojo.MoveDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/14.
 */
@Service
public class MoveDetailsService {

    @Autowired
    private MoveDetailsMapper moveDetailsmapper;

    //查询所有
    public List<MoveDetails> getAllMoveDetails() {
        List<MoveDetails> list = this.moveDetailsmapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
    //查询单个
    public MoveDetails getMoveDetails(Integer id){
        MoveDetails MoveDetails = this.moveDetailsmapper.selectByPrimaryKey(id);
        if (MoveDetails == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MoveDetails;
    }
}
