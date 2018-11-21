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

    //删除
    public void deleteMallRecord(Integer id) {
        int count = this.mallRecordmapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMallRecord(MallRecord mallRecord) {
        int count = this.mallRecordmapper.updateByPrimaryKeySelective(mallRecord);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<MallRecord> getAllMallRecord() {
        List<MallRecord> list = this.mallRecordmapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public MallRecord getMallRecord(Integer id) {
        MallRecord MallRecord = this.mallRecordmapper.selectByPrimaryKey(id);
        if (MallRecord == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MallRecord;
    }

    //字段搜索
    public List<MallRecord> searchMallRecord(String keywords) {
        Example example = new Example(MallRecord.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<MallRecord> list = this.mallRecordmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
