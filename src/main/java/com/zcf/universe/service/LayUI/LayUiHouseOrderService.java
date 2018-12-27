package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HouseOrderMapper;
import com.zcf.universe.pojo.HouseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/27
 */
@Service
public class LayUiHouseOrderService {

    @Autowired
    private HouseOrderMapper LayUiHouseOrderMapper;

    //新增
    public boolean add(HouseOrder houseOrder) {
        return this.LayUiHouseOrderMapper.insert(houseOrder) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiHouseOrderMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(HouseOrder houseOrder) {
        return this.LayUiHouseOrderMapper.updateByPrimaryKeySelective(houseOrder) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HouseOrder> list = this.LayUiHouseOrderMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
    public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(HouseOrder.class);
        example.createCriteria().andLike("id", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<HouseOrder> list = this.LayUiHouseOrderMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
