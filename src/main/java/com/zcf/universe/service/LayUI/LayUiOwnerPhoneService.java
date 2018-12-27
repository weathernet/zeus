package com.zcf.universe.service.LayUI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.mapper.OwnerPhoneMapper;
import com.zcf.universe.pojo.OwnerPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author YuanQJ
 * @date 2018/12/25
 */
@Service
public class LayUiOwnerPhoneService {

    @Autowired
    private OwnerPhoneMapper LayUiOwnerPhoneMapper;

    //更新
    public boolean update(OwnerPhone ownerPhone) {
        return this.LayUiOwnerPhoneMapper.updateByPrimaryKeySelective(ownerPhone) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OwnerPhone> list = this.LayUiOwnerPhoneMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

}
