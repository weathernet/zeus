package com.zcf.universe.service;

import com.zcf.universe.pojo.MallGoods;
import com.zcf.universe.mapper.MallGoodsMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/18.
 */
@Service
public class MallGoodsService {

    @Autowired
    private MallGoodsMapper mallGoodsmapper;

    //新增
    public void addMallGoods(MallGoods mallGoods) {
        int count = this.mallGoodsmapper.insertSelective(mallGoods);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMallGoods(Integer id) {
        int count = this.mallGoodsmapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMallGoods(MallGoods mallGoods) {
        int count = this.mallGoodsmapper.updateByPrimaryKeySelective(mallGoods);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询一个商品的详情
    public MallGoods getMallGoods(Integer id) {
        MallGoods MallGoods = this.mallGoodsmapper.selectByPrimaryKey(id);
        if (MallGoods == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MallGoods;
    }

    //字段搜索
    public List<MallGoods> searchMallGoodsByGroupId(Integer groupid) {
        Example example = new Example(MallGoods.class);
        example.createCriteria().andEqualTo("goodsSort", groupid.toString());//name为你想要搜索的字段
        List<MallGoods> list = this.mallGoodsmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //商家所有的商品
    public List<MallGoods> mallAllGoods(Integer traderId) {
        Example example = new Example(MallGoods.class);
        example.createCriteria().andEqualTo("goodsTraderId", traderId);
        return this.mallGoodsmapper.selectByExample(example);
    }
}
