package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.ServiceEvaluation;
import com.zcf.universe.mapper.ServiceEvaluationMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/26.
 */
@Service
public class LayUiServiceEvaluationService{

    @Autowired
    private ServiceEvaluationMapper LayUiServiceEvaluationMapper;

    //新增
    public boolean add(ServiceEvaluation serviceEvaluation) {
        return this.LayUiServiceEvaluationMapper.insert(serviceEvaluation) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiServiceEvaluationMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(ServiceEvaluation serviceEvaluation) {
        return this.LayUiServiceEvaluationMapper.updateByPrimaryKeySelective(serviceEvaluation) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ServiceEvaluation> list = this.LayUiServiceEvaluationMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(ServiceEvaluation.class);
        example.createCriteria().andLike("evaluateId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<ServiceEvaluation> list = this.LayUiServiceEvaluationMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
