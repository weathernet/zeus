package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.MoveOrderMapper;
import com.zcf.universe.pojo.MoveOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/15.
 */
@Service
public class LayUiMoveOrderService {

    @Autowired
    private MoveOrderMapper LayUiMoveOrderMapper;

    //新增
    public boolean add(MoveOrder moveOrder) {
        return this.LayUiMoveOrderMapper.insert(moveOrder) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiMoveOrderMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(MoveOrder moveOrder) {
        return this.LayUiMoveOrderMapper.updateByPrimaryKeySelective(moveOrder) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MoveOrder> list = this.LayUiMoveOrderMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(MoveOrder.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<MoveOrder> list = this.LayUiMoveOrderMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
