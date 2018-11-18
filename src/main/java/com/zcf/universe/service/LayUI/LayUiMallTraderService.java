package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.MallTrader;
import com.zcf.universe.mapper.MallTraderMapper;
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
public class LayUiMallTraderService{

    @Autowired
    private MallTraderMapper LayUiMallTraderMapper;

    //新增
    public boolean add(MallTrader mallTrader) {
        return this.LayUiMallTraderMapper.insert(mallTrader) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiMallTraderMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(MallTrader mallTrader) {
        return this.LayUiMallTraderMapper.updateByPrimaryKeySelective(mallTrader) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MallTrader> list = this.LayUiMallTraderMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(MallTrader.class);
        example.createCriteria().andLike("traderId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<MallTrader> list = this.LayUiMallTraderMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
