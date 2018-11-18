package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.MallEvaluate;
import com.zcf.universe.mapper.MallEvaluateMapper;
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
public class LayUiMallEvaluateService{

    @Autowired
    private MallEvaluateMapper LayUiMallEvaluateMapper;

    //新增
    public boolean add(MallEvaluate mallEvaluate) {
        return this.LayUiMallEvaluateMapper.insert(mallEvaluate) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiMallEvaluateMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(MallEvaluate mallEvaluate) {
        return this.LayUiMallEvaluateMapper.updateByPrimaryKeySelective(mallEvaluate) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MallEvaluate> list = this.LayUiMallEvaluateMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(MallEvaluate.class);
        example.createCriteria().andLike("evaluateId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<MallEvaluate> list = this.LayUiMallEvaluateMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
