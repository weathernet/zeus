package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.mapper.MallOrderMapper;
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
public class LayUiMallOrderService{

    @Autowired
    private MallOrderMapper LayUiMallOrderMapper;

    //新增
    public boolean add(MallOrder mallOrder) {
        return this.LayUiMallOrderMapper.insert(mallOrder) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiMallOrderMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(MallOrder mallOrder) {
        return this.LayUiMallOrderMapper.updateByPrimaryKeySelective(mallOrder) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MallOrder> list = this.LayUiMallOrderMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(MallOrder.class);
        example.createCriteria().andLike("orderId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<MallOrder> list = this.LayUiMallOrderMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
