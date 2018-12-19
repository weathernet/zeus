package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.IntegralRecordMapper;
import com.zcf.universe.pojo.IntegralRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
* @author YuanQJ
* @date 2018/12/18
*/
@Service
public class IntegralRecordService{

    @Autowired
    private IntegralRecordMapper integralRecordmapper;

    //新增
    public void addIntegralRecord(IntegralRecord integralRecord) {
        int count = this.integralRecordmapper.insertSelective(integralRecord);
        if(count != 1){
             throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }
    }

    //删除
    public void deleteIntegralRecordById(Integer id) {
        int count = this.integralRecordmapper.deleteByPrimaryKey(id);
        if(count != 1){
             throw new CommonException(ExceptionEnum.DELETE_FAILURE);
        }
    }

    //更新
    public void updateIntegralRecord(IntegralRecord integralRecord) {
        int count = this.integralRecordmapper.updateByPrimaryKeySelective(integralRecord);
         if(count != 1){
             throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }

    //查询所有
    public List<IntegralRecord> getAllIntegralRecord() {
        List<IntegralRecord> list = this.integralRecordmapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }

    //查询单个
    public IntegralRecord getIntegralRecord(Integer id){
        IntegralRecord IntegralRecord = this.integralRecordmapper.selectByPrimaryKey(id);
        if (IntegralRecord == null) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return IntegralRecord;
    }

    //字段搜索
     public List<IntegralRecord> searchIntegralRecord(String keywords) {
        Example example = new Example(IntegralRecord.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<IntegralRecord> list = this.integralRecordmapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return list;
    }
}
