package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HomeRecommendMapper;
import com.zcf.universe.pojo.HomeRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@Service
public class LayUiHomeRecommendService {

    @Autowired
    private HomeRecommendMapper LayUihomeRecommendmapper;

    public boolean add(HomeRecommend homeRecommend) {
        return this.LayUihomeRecommendmapper.insert(homeRecommend) == 1;
    }

    public boolean delete(Integer id) {
        return this.LayUihomeRecommendmapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(HomeRecommend homeRecommend) {
        return this.LayUihomeRecommendmapper.updateByPrimaryKeySelective(homeRecommend) == 1;
    }

    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HomeRecommend> list = this.LayUihomeRecommendmapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(HomeRecommend.class);
        keywords = "%" + keywords + "%";
        example.createCriteria().andLike("name", keywords);//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<HomeRecommend> list = this.LayUihomeRecommendmapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
