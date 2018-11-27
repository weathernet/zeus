package com.zcf.universe.service;

import com.zcf.universe.mapper.UserInfoMapper;
import com.zcf.universe.pojo.TravelOrder;
import com.zcf.universe.mapper.TravelOrderMapper;
import com.zcf.universe.pojo.UserInfo;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;

import java.util.Date;
import java.util.List;

/**
 * Created by YuanQJ on 2018/11/19.
 */
@Service
public class TravelOrderService {

    @Autowired
    private TravelOrderMapper travelOrdermapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    //新增
    public void addOrder(TravelOrder travelOrder) {
        travelOrder.setCreateTime(new Date());
        travelOrder.setUpdateTime(new Date());
        travelOrder.setOrderState("0");
        if ("1".equals(travelOrder.getOrderPaytype())) {//微信支付
            throw new CommonException(ExceptionEnum.INVALID_PAY_TYPE);
        } else if ("2".equals(travelOrder.getOrderPaytype())) {//支付宝支付
            throw new CommonException(ExceptionEnum.INVALID_PAY_TYPE);
        } else if ("3".equals(travelOrder.getOrderPaytype())) {//余额支付
            UserInfo user = userInfoMapper.selectByPrimaryKey(travelOrder.getOrderUserId());
            if (user != null && Double.parseDouble(user.getUserWallet()) >= Double.parseDouble(travelOrder.getOrderSumPrice())) {
                user.setUserWallet((Double.parseDouble(user.getUserWallet()) - Double.parseDouble(travelOrder.getOrderSumPrice())) + "");
                userInfoMapper.updateByPrimaryKeySelective(user);
                travelOrder.setOrderState("1");
                int count = this.travelOrdermapper.insertSelective(travelOrder);
                if (count != 1) {
                    throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
                }
            } else {
                throw new CommonException(ExceptionEnum.INVALID_PAY_TYPE);
            }
        } else {
            throw new CommonException(ExceptionEnum.INVALID_PAY_TYPE);
        }
    }

    //使用订单
    public void useTravelOrder(String orderid) {
        TravelOrder travelOrder = this.travelOrdermapper.selectByPrimaryKey(Integer.parseInt(orderid));
        travelOrder.setOrderState("2");
        int count = this.travelOrdermapper.updateByPrimaryKeySelective(travelOrder);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //订单过期
    public void overTravelOrder(String orderid) {
        TravelOrder travelOrder = this.travelOrdermapper.selectByPrimaryKey(Integer.parseInt(orderid));
        travelOrder.setOrderState("3");
        int count = this.travelOrdermapper.updateByPrimaryKeySelective(travelOrder);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //取消订单
    public void cancelTravelOrder(Integer id) {
        int count = this.travelOrdermapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    /************************************************************************************************************/

    //新增
    public void addTravelOrder(TravelOrder travelOrder) {
        int count = this.travelOrdermapper.insertSelective(travelOrder);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteTravelOrder(Integer id) {
        int count = this.travelOrdermapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateTravelOrder(TravelOrder travelOrder) {
        int count = this.travelOrdermapper.updateByPrimaryKeySelective(travelOrder);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<TravelOrder> getAllTravelOrder() {
        List<TravelOrder> list = this.travelOrdermapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public TravelOrder getTravelOrder(Integer id) {
        TravelOrder TravelOrder = this.travelOrdermapper.selectByPrimaryKey(id);
        if (TravelOrder == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return TravelOrder;
    }

    //字段搜索
    public List<TravelOrder> searchTravelOrder(String keywords) {
        Example example = new Example(TravelOrder.class);
        example.createCriteria().andLike("orderUserId", keywords);//name为你想要搜索的字段
        List<TravelOrder> list = this.travelOrdermapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
