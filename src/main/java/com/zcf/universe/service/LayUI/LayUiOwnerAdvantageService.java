package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.OwnerAdvantageMapper;
import com.zcf.universe.pojo.OwnerAdvantage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@Service
public class LayUiOwnerAdvantageService {

    @Autowired
    private OwnerAdvantageMapper LayUiOwnerAdvantageMapper;

    //更新
    public boolean update(OwnerAdvantage ownerAdvantage) {
        return this.LayUiOwnerAdvantageMapper.updateByPrimaryKeySelective(ownerAdvantage) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OwnerAdvantage> list = this.LayUiOwnerAdvantageMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

}
