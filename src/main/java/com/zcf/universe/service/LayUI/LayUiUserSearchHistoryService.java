package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.UserSearchHistory;
import com.zcf.universe.mapper.UserSearchHistoryMapper;
import com.zcf.universe.common.utils.LayUiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/19.
 */
@Service
public class LayUiUserSearchHistoryService{

    @Autowired
    private UserSearchHistoryMapper LayUiUserSearchHistoryMapper;

    //新增
    public boolean add(UserSearchHistory userSearchHistory) {
        return this.LayUiUserSearchHistoryMapper.insert(userSearchHistory) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiUserSearchHistoryMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(UserSearchHistory userSearchHistory) {
        return this.LayUiUserSearchHistoryMapper.updateByPrimaryKeySelective(userSearchHistory) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<UserSearchHistory> list = this.LayUiUserSearchHistoryMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(UserSearchHistory.class);
        example.createCriteria().andLike("historyId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<UserSearchHistory> list = this.LayUiUserSearchHistoryMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
