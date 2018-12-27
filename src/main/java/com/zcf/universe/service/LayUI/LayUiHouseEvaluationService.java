package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HouseEvaluationMapper;
import com.zcf.universe.pojo.HouseEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
* @author YuanQJ
* @date 2018/12/26
*/
@Service
public class LayUiHouseEvaluationService {

    @Autowired
    private HouseEvaluationMapper LayUiHouseEvaluationMapper;

    //新增
    public boolean add(HouseEvaluation houseEvaluation) {
        return this.LayUiHouseEvaluationMapper.insert(houseEvaluation) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiHouseEvaluationMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(HouseEvaluation houseEvaluation) {
        return this.LayUiHouseEvaluationMapper.updateByPrimaryKeySelective(houseEvaluation) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HouseEvaluation> list = this.LayUiHouseEvaluationMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(HouseEvaluation.class);
        example.createCriteria().andLike("id", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<HouseEvaluation> list = this.LayUiHouseEvaluationMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
