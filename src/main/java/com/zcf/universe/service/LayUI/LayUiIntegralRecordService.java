package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.IntegralRecordMapper;
import com.zcf.universe.pojo.IntegralRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
* @author YuanQJ
* @date 2018/12/18
*/
@Service
public class LayUiIntegralRecordService{

    @Autowired
    private IntegralRecordMapper LayUiIntegralRecordMapper;

    //新增
    public boolean add(IntegralRecord integralRecord) {
        return this.LayUiIntegralRecordMapper.insert(integralRecord) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiIntegralRecordMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(IntegralRecord integralRecord) {
        return this.LayUiIntegralRecordMapper.updateByPrimaryKeySelective(integralRecord) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<IntegralRecord> list = this.LayUiIntegralRecordMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(IntegralRecord.class);
        example.createCriteria().andLike("recordId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<IntegralRecord> list = this.LayUiIntegralRecordMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
