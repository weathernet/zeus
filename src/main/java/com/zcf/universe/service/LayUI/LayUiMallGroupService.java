package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.MallGroup;
import com.zcf.universe.mapper.MallGroupMapper;
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
public class LayUiMallGroupService{

    @Autowired
    private MallGroupMapper LayUiMallGroupMapper;

    //新增
    public boolean add(MallGroup mallGroup) {
        return this.LayUiMallGroupMapper.insert(mallGroup) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiMallGroupMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(MallGroup mallGroup) {
        return this.LayUiMallGroupMapper.updateByPrimaryKeySelective(mallGroup) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MallGroup> list = this.LayUiMallGroupMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(MallGroup.class);
        example.createCriteria().andLike("groupId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<MallGroup> list = this.LayUiMallGroupMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
