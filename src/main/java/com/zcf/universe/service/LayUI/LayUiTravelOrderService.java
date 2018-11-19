package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.TravelOrder;
import com.zcf.universe.mapper.TravelOrderMapper;
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
public class LayUiTravelOrderService{

    @Autowired
    private TravelOrderMapper LayUiTravelOrderMapper;

    //新增
    public boolean add(TravelOrder travelOrder) {
        return this.LayUiTravelOrderMapper.insert(travelOrder) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiTravelOrderMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(TravelOrder travelOrder) {
        return this.LayUiTravelOrderMapper.updateByPrimaryKeySelective(travelOrder) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TravelOrder> list = this.LayUiTravelOrderMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(TravelOrder.class);
        example.createCriteria().andLike("orderId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<TravelOrder> list = this.LayUiTravelOrderMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
