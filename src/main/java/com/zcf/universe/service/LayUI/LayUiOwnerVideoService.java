package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.OwnerVideo;
import com.zcf.universe.mapper.OwnerVideoMapper;
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
public class LayUiOwnerVideoService{

    @Autowired
    private OwnerVideoMapper LayUiOwnerVideoMapper;

    //新增
    public boolean add(OwnerVideo ownerVideo) {
        return this.LayUiOwnerVideoMapper.insert(ownerVideo) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiOwnerVideoMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(OwnerVideo ownerVideo) {
        return this.LayUiOwnerVideoMapper.updateByPrimaryKeySelective(ownerVideo) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OwnerVideo> list = this.LayUiOwnerVideoMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(OwnerVideo.class);
        example.createCriteria().andLike("videoId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<OwnerVideo> list = this.LayUiOwnerVideoMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
