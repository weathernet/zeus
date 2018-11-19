package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.TravelEvaluate;
import com.zcf.universe.mapper.TravelEvaluateMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/19.
 */
@Service
public class LayUiTravelEvaluateService{

    @Autowired
    private TravelEvaluateMapper LayUiTravelEvaluateMapper;

    //新增
    public boolean add(TravelEvaluate travelEvaluate) {
        return this.LayUiTravelEvaluateMapper.insert(travelEvaluate) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiTravelEvaluateMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(TravelEvaluate travelEvaluate) {
        return this.LayUiTravelEvaluateMapper.updateByPrimaryKeySelective(travelEvaluate) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TravelEvaluate> list = this.LayUiTravelEvaluateMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(TravelEvaluate.class);
        example.createCriteria().andLike("evaluateId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<TravelEvaluate> list = this.LayUiTravelEvaluateMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
