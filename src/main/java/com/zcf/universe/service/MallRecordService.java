package com.zcf.universe.service;

import com.zcf.universe.pojo.MallRecord;
import com.zcf.universe.mapper.MallRecordMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/18.
 */
@Service
public class MallRecordService {

    @Autowired
    private MallRecordMapper mallRecordmapper;

    //新增
    public void addMallRecord(MallRecord mallRecord) {
        int count = this.mallRecordmapper.insertSelective(mallRecord);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询该用户的消费状态
    public List<MallRecord> getAllMallRecord(Integer userId) {
        Example example = new Example(MallRecord.class);
        example.createCriteria().andEqualTo("recordUserId", userId);
        return this.mallRecordmapper.selectByExample(example);
    }

}
