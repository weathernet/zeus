package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HouseMoveMapper;
import com.zcf.universe.pojo.HouseMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/14.
 */
@Service
public class LayUiHouseMoveService {

    @Autowired
    private HouseMoveMapper LayUiHouseMoveMapper;

    //新增
    public boolean add(HouseMove houseMove) {
        return this.LayUiHouseMoveMapper.insert(houseMove) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiHouseMoveMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(HouseMove houseMove) {
        return this.LayUiHouseMoveMapper.updateByPrimaryKeySelective(houseMove) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HouseMove> list = this.LayUiHouseMoveMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(HouseMove.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<HouseMove> list = this.LayUiHouseMoveMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
