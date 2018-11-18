package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.MallRecord;
import com.zcf.universe.mapper.MallRecordMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/18.
 */
@Service
public class LayUiMallRecordService{

    @Autowired
    private MallRecordMapper LayUiMallRecordMapper;

    //新增
    public boolean add(MallRecord mallRecord) {
        return this.LayUiMallRecordMapper.insert(mallRecord) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiMallRecordMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(MallRecord mallRecord) {
        return this.LayUiMallRecordMapper.updateByPrimaryKeySelective(mallRecord) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MallRecord> list = this.LayUiMallRecordMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(MallRecord.class);
        example.createCriteria().andLike("recordId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<MallRecord> list = this.LayUiMallRecordMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
