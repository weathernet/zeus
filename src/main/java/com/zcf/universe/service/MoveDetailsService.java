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

    //新增
    public void addMoveDetails(MoveDetails moveDetails) {
        boolean flag = this.moveDetailsmapper.insert(moveDetails) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMoveDetails(Integer id) {
        boolean flag = this.moveDetailsmapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMoveDetails(MoveDetails moveDetails) {
        boolean flag =this.moveDetailsmapper.updateByPrimaryKeySelective(moveDetails) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

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

    //字段搜索
     public List<MoveDetails> searchMoveDetails(String keywords) {
        Example example = new Example(MoveDetails.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<MoveDetails> list = this.moveDetailsmapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
