package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HomeStoryMapper;
import com.zcf.universe.pojo.HomeStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/07.
 */
@Service
public class LayUiHomeStoryService {

    @Autowired
    private HomeStoryMapper LayUihomeStorymapper;

    public boolean add(HomeStory homeStory) {
        return this.LayUihomeStorymapper.insert(homeStory) == 1;
    }

    public boolean delete(Integer id) {
        return this.LayUihomeStorymapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(HomeStory homeStory) {
        return this.LayUihomeStorymapper.updateByPrimaryKeySelective(homeStory) == 1;
    }

    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HomeStory> list = this.LayUihomeStorymapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(HomeStory.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<HomeStory> list = this.LayUihomeStorymapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
