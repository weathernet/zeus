package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HomeTravelMapper;
import com.zcf.universe.pojo.HomeTravel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
* @author 袁齐吉
* @date 2018/12/28
*/
@Service
public class LayUiHomeTravelService {

    @Autowired
    private HomeTravelMapper LayUiHomeTravelMapper;

    //新增
    public boolean add(HomeTravel homeTravel) {
        return this.LayUiHomeTravelMapper.insert(homeTravel) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiHomeTravelMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(HomeTravel homeTravel) {
        return this.LayUiHomeTravelMapper.updateByPrimaryKeySelective(homeTravel) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HomeTravel> list = this.LayUiHomeTravelMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(HomeTravel.class);
        example.createCriteria().andLike("travelId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<HomeTravel> list = this.LayUiHomeTravelMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
