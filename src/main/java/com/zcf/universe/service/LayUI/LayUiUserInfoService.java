package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.UserInfoMapper;
import com.zcf.universe.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * Created by YuanQJ on 2018/11/05.
 */
@Service
public class LayUiUserInfoService {

    @Autowired
    private UserInfoMapper LayUiuserInfomapper;

    public boolean add(UserInfo userInfo) {
        return this.LayUiuserInfomapper.insert(userInfo) == 1;
    }

    public boolean delete(Integer id) {
        return this.LayUiuserInfomapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(UserInfo userInfo) {
        return this.LayUiuserInfomapper.updateByPrimaryKeySelective(userInfo) == 1;
    }

    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<UserInfo> list = this.LayUiuserInfomapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

     public LayUiResult search(Integer page, Integer limit, String keywords) {
        Example example = new Example(UserInfo.class);
        keywords = "%" + keywords + "%";
        example.createCriteria().andLike("name", keywords);//name为你想要搜索的字段
        PageHelper.startPage(page, limit);
        List<UserInfo> list = this.LayUiuserInfomapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
