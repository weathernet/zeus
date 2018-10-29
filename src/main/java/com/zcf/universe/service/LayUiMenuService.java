package com.zcf.universe.service;

import com.zcf.universe.pojo.LayUIMeun.LayuiParentMenu;
import com.zcf.universe.pojo.LayUIMeun.LayuiSubMenu;
import com.zcf.universe.mapper.LayuiParentMenuMapper;
import com.zcf.universe.mapper.LayuiSubMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author yuan
 * @date 2018/10/23 0023
 */
@Service
public class LayUiMenuService {
    @Autowired
    private LayuiParentMenuMapper parentMenuMapper;

    @Autowired
    private LayuiSubMenuMapper subMenuMapper;

    public List<LayuiParentMenu> menu() {
        List<LayuiParentMenu> parentMenus = this.parentMenuMapper.selectAll();
        if (parentMenus.size() != 0) {
            for (LayuiParentMenu parentMenu : parentMenus) {
                Integer parentId = parentMenu.getParentId();
                Example example = new Example(LayuiSubMenu.class);
                example.createCriteria().andEqualTo("subMenuId", parentId);
                List<LayuiSubMenu> layupSubMenus = this.subMenuMapper.selectByExample(example);
                parentMenu.setList(layupSubMenus);
            }
        }
        return parentMenus;
    }

}
