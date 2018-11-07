package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.HomeBannerMapper;
import com.zcf.universe.pojo.HomeBanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/07.
 */
@Service
public class LayUiHomeBannerService {

    @Autowired
    private HomeBannerMapper LayUihomeBannermapper;

    public boolean add(HomeBanner homeBanner) {
        return this.LayUihomeBannermapper.insert(homeBanner) == 1;
    }

    public boolean delete(Integer id) {
        return this.LayUihomeBannermapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(HomeBanner homeBanner) {
        return this.LayUihomeBannermapper.updateByPrimaryKeySelective(homeBanner) == 1;
    }

    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HomeBanner> list = this.LayUihomeBannermapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(HomeBanner.class);
        keywords = "%" + keywords + "%";
        example.createCriteria().andLike("name", keywords);//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<HomeBanner> list = this.LayUihomeBannermapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
