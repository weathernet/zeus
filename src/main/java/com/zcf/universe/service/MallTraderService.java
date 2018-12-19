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

    //商家账户登录
    public MallTrader getMallTrader(String traderName, String traderPassword) {
        Example example = new Example(MallTrader.class);
        example.createCriteria()
                .andEqualTo("traderName", traderName)
                .andEqualTo("traderPassword", traderPassword);
        return this.mallTradermapper.selectOneByExample(example);
    }
}
