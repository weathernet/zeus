package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.UserCollectionMapper;
import com.zcf.universe.pojo.UserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@Service
public class LayUiUserCollectionService {

    @Autowired
    private UserCollectionMapper LayUiUserCollectionMapper;

    //新增
    public boolean add(UserCollection userCollection) {
        return this.LayUiUserCollectionMapper.insert(userCollection) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiUserCollectionMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(UserCollection userCollection) {
        return this.LayUiUserCollectionMapper.updateByPrimaryKeySelective(userCollection) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<UserCollection> list = this.LayUiUserCollectionMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
    public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(UserCollection.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<UserCollection> list = this.LayUiUserCollectionMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
