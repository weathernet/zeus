package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HouseLabelMapper;
import com.zcf.universe.pojo.HouseLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/06.
 */
@Service
public class LayUiHouseLabelService {

    @Autowired
    private HouseLabelMapper LayUihouseLabelmapper;

    public boolean add(HouseLabel houseLabel) {
        return this.LayUihouseLabelmapper.insert(houseLabel) == 1;
    }

    public boolean delete(Integer id) {
        return this.LayUihouseLabelmapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(HouseLabel houseLabel) {
        return this.LayUihouseLabelmapper.updateByPrimaryKeySelective(houseLabel) == 1;
    }

    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HouseLabel> list = this.LayUihouseLabelmapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(HouseLabel.class);
        keywords = "%" + keywords + "%";
        example.createCriteria().andLike("labelName", keywords);//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<HouseLabel> list = this.LayUihouseLabelmapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
