package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.OwnerQuotationMapper;
import com.zcf.universe.pojo.OwnerQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
* @author YuanQJ
* @date 2018/12/26
*/
@Service
public class LayUiOwnerQuotationService {

    @Autowired
    private OwnerQuotationMapper LayUiOwnerQuotationMapper;

    //新增
    public boolean add(OwnerQuotation ownerQuotation) {
        return this.LayUiOwnerQuotationMapper.insert(ownerQuotation) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiOwnerQuotationMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(OwnerQuotation ownerQuotation) {
        return this.LayUiOwnerQuotationMapper.updateByPrimaryKeySelective(ownerQuotation) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OwnerQuotation> list = this.LayUiOwnerQuotationMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(OwnerQuotation.class);
        example.createCriteria().andLike("id", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<OwnerQuotation> list = this.LayUiOwnerQuotationMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
