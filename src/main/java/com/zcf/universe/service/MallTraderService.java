package com.zcf.universe.service;

import com.zcf.universe.pojo.MallTrader;
import com.zcf.universe.mapper.MallTraderMapper;
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
public class MallTraderService {

    @Autowired
    private MallTraderMapper mallTradermapper;

    //新增
    public void addMallTrader(MallTrader mallTrader) {
        int count = this.mallTradermapper.insert(mallTrader);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMallTrader(Integer id) {
        int count = this.mallTradermapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMallTrader(MallTrader mallTrader) {
        int count = this.mallTradermapper.updateByPrimaryKeySelective(mallTrader);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<MallTrader> getAllMallTrader() {
        List<MallTrader> list = this.mallTradermapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public MallTrader getMallTrader(Integer id) {
        MallTrader MallTrader = this.mallTradermapper.selectByPrimaryKey(id);
        if (MallTrader == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MallTrader;
    }

    //字段搜索
    public List<MallTrader> searchMallTrader(String keywords) {
        Example example = new Example(MallTrader.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<MallTrader> list = this.mallTradermapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
