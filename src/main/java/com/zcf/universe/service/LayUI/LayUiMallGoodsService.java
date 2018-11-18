package com.zcf.universe.service.LayUI;

import com.zcf.universe.pojo.MallGoods;
import com.zcf.universe.mapper.MallGoodsMapper;
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
public class LayUiMallGoodsService{

    @Autowired
    private MallGoodsMapper LayUiMallGoodsMapper;

    //新增
    public boolean add(MallGoods mallGoods) {
        return this.LayUiMallGoodsMapper.insert(mallGoods) == 1;
    }

    //删除
    public boolean delete(Integer id) {
        return this.LayUiMallGoodsMapper.deleteByPrimaryKey(id) == 1;
    }

    //更新
    public boolean update(MallGoods mallGoods) {
        return this.LayUiMallGoodsMapper.updateByPrimaryKeySelective(mallGoods) == 1;
    }

    //查询
    public LayUiResult query(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MallGoods> list = this.LayUiMallGoodsMapper.selectAll();
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }

    //搜索
     public LayUiResult search(Integer page, Integer limit,String keywords) {
        Example example = new Example(MallGoods.class);
        example.createCriteria().andLike("goodsId", "%" + keywords + "%");
        PageHelper.startPage(page, limit);
        List<MallGoods> list = this.LayUiMallGoodsMapper.selectByExample(example);
        return new LayUiResult("0", "查询成功", new PageInfo<>(list).getTotal(), list);
    }
}
