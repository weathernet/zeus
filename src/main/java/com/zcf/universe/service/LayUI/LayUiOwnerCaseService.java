package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.OwnerCase;
import com.zcf.universe.mapper.OwnerCaseMapper;
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
public class LayUiOwnerCaseService{

    @Autowired
    private OwnerCaseMapper LayUiOwnerCaseMapper;

    //新增
    public boolean add(OwnerCase ownerCase) {
        return this.LayUiOwnerCaseMapper.insert(ownerCase) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiOwnerCaseMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(OwnerCase ownerCase) {
        return this.LayUiOwnerCaseMapper.updateByPrimaryKeySelective(ownerCase) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OwnerCase> list = this.LayUiOwnerCaseMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(OwnerCase.class);
        example.createCriteria().andLike("caseId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<OwnerCase> list = this.LayUiOwnerCaseMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
