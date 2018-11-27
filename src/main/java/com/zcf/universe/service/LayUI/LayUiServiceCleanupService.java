package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.ServiceCleanup;
import com.zcf.universe.mapper.ServiceCleanupMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/26.
 */
@Service
public class LayUiServiceCleanupService{

    @Autowired
    private ServiceCleanupMapper LayUiServiceCleanupMapper;

    //新增
    public boolean add(ServiceCleanup serviceCleanup) {
        return this.LayUiServiceCleanupMapper.insert(serviceCleanup) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiServiceCleanupMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(ServiceCleanup serviceCleanup) {
        return this.LayUiServiceCleanupMapper.updateByPrimaryKeySelective(serviceCleanup) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ServiceCleanup> list = this.LayUiServiceCleanupMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(ServiceCleanup.class);
        example.createCriteria().andLike("cleanupId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<ServiceCleanup> list = this.LayUiServiceCleanupMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
