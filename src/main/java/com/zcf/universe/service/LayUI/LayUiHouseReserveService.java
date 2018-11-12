package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HouseReserveMapper;
import com.zcf.universe.pojo.HouseReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/09.
 */
@Service
public class LayUiHouseReserveService {

    @Autowired
    private HouseReserveMapper LayUiHouseReserveMapper;

    //新增
    public boolean add(HouseReserve houseReserve) {
        return this.LayUiHouseReserveMapper.insert(houseReserve) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiHouseReserveMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(HouseReserve houseReserve) {
        return this.LayUiHouseReserveMapper.updateByPrimaryKeySelective(houseReserve) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HouseReserve> list = this.LayUiHouseReserveMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(HouseReserve.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<HouseReserve> list = this.LayUiHouseReserveMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
