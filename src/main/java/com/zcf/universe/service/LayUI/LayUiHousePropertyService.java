package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HousePropertyMapper;
import com.zcf.universe.pojo.HouseProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 袁齐吉
 * @date 2018/12/28
 */
@Service
public class LayUiHousePropertyService {

    @Autowired
    private HousePropertyMapper LayUiHousePropertyMapper;

    //新增
    public boolean add(HouseProperty houseProperty) {
        return this.LayUiHousePropertyMapper.insert(houseProperty) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiHousePropertyMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(HouseProperty houseProperty) {
        return this.LayUiHousePropertyMapper.updateByPrimaryKeySelective(houseProperty) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HouseProperty> list = this.LayUiHousePropertyMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
    public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(HouseProperty.class);
        example.createCriteria().andLike("id", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<HouseProperty> list = this.LayUiHousePropertyMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
