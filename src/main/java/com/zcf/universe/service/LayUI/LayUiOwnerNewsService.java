package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.OwnerNews;
import com.zcf.universe.mapper.OwnerNewsMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/22.
 */
@Service
public class LayUiOwnerNewsService{

    @Autowired
    private OwnerNewsMapper LayUiOwnerNewsMapper;

    //新增
    public boolean add(OwnerNews ownerNews) {
        return this.LayUiOwnerNewsMapper.insert(ownerNews) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiOwnerNewsMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(OwnerNews ownerNews) {
        return this.LayUiOwnerNewsMapper.updateByPrimaryKeySelective(ownerNews) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OwnerNews> list = this.LayUiOwnerNewsMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(OwnerNews.class);
        example.createCriteria().andLike("newsId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<OwnerNews> list = this.LayUiOwnerNewsMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
