package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.MallBanner;
import com.zcf.universe.mapper.MallBannerMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/18.
 */
@Service
public class LayUiMallBannerService{

    @Autowired
    private MallBannerMapper LayUiMallBannerMapper;

    //新增
    public boolean add(MallBanner mallBanner) {
        return this.LayUiMallBannerMapper.insert(mallBanner) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiMallBannerMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(MallBanner mallBanner) {
        return this.LayUiMallBannerMapper.updateByPrimaryKeySelective(mallBanner) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MallBanner> list = this.LayUiMallBannerMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(MallBanner.class);
        example.createCriteria().andLike("bannerId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<MallBanner> list = this.LayUiMallBannerMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
