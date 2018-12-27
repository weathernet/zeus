package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.OwnerEntrustMapper;
import com.zcf.universe.pojo.OwnerEntrust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@Service
public class LayUiOwnerEntrustService {

    @Autowired
    private OwnerEntrustMapper LayUiOwnerEntrustMapper;

    //新增
    public boolean add(OwnerEntrust ownerEntrust) {
        return this.LayUiOwnerEntrustMapper.insert(ownerEntrust) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiOwnerEntrustMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(OwnerEntrust ownerEntrust) {
        return this.LayUiOwnerEntrustMapper.updateByPrimaryKeySelective(ownerEntrust) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OwnerEntrust> list = this.LayUiOwnerEntrustMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
    public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(OwnerEntrust.class);
        example.createCriteria().andLike("id", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<OwnerEntrust> list = this.LayUiOwnerEntrustMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
