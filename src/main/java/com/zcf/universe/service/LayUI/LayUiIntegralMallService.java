package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.IntegralMallMapper;
import com.zcf.universe.pojo.IntegralMall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
* @author 袁齐吉
* @date 2018/12/29
*/
@Service
public class LayUiIntegralMallService {

    @Autowired
    private IntegralMallMapper LayUiIntegralMallMapper;

    //新增
    public boolean add(IntegralMall integralMall) {
        return this.LayUiIntegralMallMapper.insert(integralMall) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiIntegralMallMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(IntegralMall integralMall) {
        return this.LayUiIntegralMallMapper.updateByPrimaryKeySelective(integralMall) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<IntegralMall> list = this.LayUiIntegralMallMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(IntegralMall.class);
        example.createCriteria().andLike("integralId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<IntegralMall> list = this.LayUiIntegralMallMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
