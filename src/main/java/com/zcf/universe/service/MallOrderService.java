package com.zcf.universe.service;

import com.zcf.universe.mapper.UserInfoMapper;
import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.mapper.MallOrderMapper;
import com.zcf.universe.pojo.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;

import java.util.Date;
import java.util.List;

/**
 * Created by YuanQJ on 2018/11/18.
 */
@Service
public class MallOrderService {

    @Autowired
    private MallOrderMapper mallOrdermapper;

    @Autowired
    private UserInfoMapper userInfomapper;

    //订单付款
    public ResponseEntity<Void> updateOrder(String orderid, Integer userid, String money, String paytype) {
        MallOrder mallOrder = new MallOrder();
        UserInfo userInfo = userInfomapper.selectByPrimaryKey(userid);
        if ("1".equals(paytype)) {//支付宝支付
            throw new CommonException(ExceptionEnum.INVALID_PAY_TYPE);
        } else if ("2".equals(paytype)) {//微信支付
            throw new CommonException(ExceptionEnum.INVALID_PAY_TYPE);
        } else if ("3".equals(paytype)) {//余额支付
            if (Double.parseDouble(userInfo.getUserWallet()) > Double.parseDouble(money)) {
                Double wallet = Double.parseDouble(userInfo.getUserWallet()) - Double.parseDouble(money);
                userInfo.setUserWallet(wallet.toString());
                userInfomapper.updateByPrimaryKeySelective(userInfo);
                mallOrder.setOrderStatus(1);
                mallOrder.setUpdateTime(new Date());
                mallOrder.setOrderId(Long.parseLong(orderid));
                mallOrdermapper.updateByPrimaryKeySelective(mallOrder);
                return ResponseEntity.ok(null);
            } else {
                throw new CommonException(ExceptionEnum.PAY_NO_MONEY);
            }
        } else {//没有支付类型
            throw new CommonException(ExceptionEnum.INVALID_PAY_TYPE);
        }

    }

    //订单发货
    public void updateOrderSendGoods(Long orderId, String userId, String orderCompany, String orderExpressNumber) {
        MallOrder mallOrder = new MallOrder();
        mallOrder.setOrderStatus(2);
        mallOrder.setOrderUserId(Integer.parseInt(userId));
        mallOrder.setOrderExpressNumber(orderExpressNumber);
        mallOrder.setOrderCompany(orderCompany);
        mallOrder.setUpdateTime(new Date());
        mallOrder.setOrderId(orderId);
        mallOrdermapper.updateByPrimaryKeySelective(mallOrder);
    }

    //订单收货
    public ResponseEntity<Void> updateOrderGetGoods(String orderid, String userid) {
        MallOrder mallOrder = new MallOrder();
        mallOrder.setUpdateTime(new Date());
        mallOrder.setOrderStatus(3);
        mallOrder.setOrderId(Long.parseLong(orderid));
        mallOrdermapper.updateByPrimaryKeySelective(mallOrder);
        return ResponseEntity.ok(null);
    }


    /**************************************************************************/

    //新增
    public void addMallOrder(MallOrder mallOrder) {
        int count = this.mallOrdermapper.insertSelective(mallOrder);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }
    }


    //查询单个
    public MallOrder getMallOrder(Integer id) {
        MallOrder MallOrder = this.mallOrdermapper.selectByPrimaryKey(id);
        if (MallOrder == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MallOrder;
    }

    public List<MallOrder> getMallOrderUser(Integer userId) {
        Example example = new Example(MallOrder.class);
        example.createCriteria()
                .andEqualTo("orderUserId", userId);
        return this.mallOrdermapper.selectByExample(example);
    }

    public void updateMallOrder(MallOrder mallOrder) {
        this.mallOrdermapper.updateByPrimaryKeySelective(mallOrder);
    }

    public List<MallOrder> mallOrderTrader(Integer TraderId, Integer status) {
        Example example = new Example(MallOrder.class);
        if (status == null) {
            example.createCriteria().andEqualTo("orderTraderId", TraderId);
        } else {
            example.createCriteria().andEqualTo("orderTraderId", TraderId).andEqualTo("orderStatus", status);
        }
        return this.mallOrdermapper.selectByExample(example);
    }
}
