package com.zcf.universe.common.wx;

import com.github.wxpay.sdk.WXPay;

import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yuan
 * @date 2018/11/21 0021
 */
@Slf4j
@Component
public class WeChatPAyHelp {
    @Autowired
    private WXPay wxPay;
    @Autowired
    private WeChatPayConfig weChatPayConfig;

    public String createOrder() {
        Long orderId = 1000000000L;
        Long total = 1L;
        String desc = "养生保健";
        try {
            Map<String, String> date = new HashMap<>();
            //商品描述
            date.put("body", desc);
            //订单号
            date.put("out_trade_no", orderId.toString());
            //金额单位是分
            date.put("total_fee", total.toString());
            //调用微信支付的终端Ip
            date.put("spbill_create_ip", "14.23.150.211");
            //回调地址
            date.put("notify_url", weChatPayConfig.getNotifyUrl());
            //交易的类型
            date.put("trade_type", "APP");
            //随机字符串
            //date.put("nonce_str", UUID.randomUUID().toString().replace("-", ""));
            Map<String, String> result = wxPay.unifiedOrder(date);
            //判断通信标识和业务标识
            isSuccess(result);
            isValidSign(result);
            result.forEach((k, v) -> System.out.println(k + " :       " + v));
            return null;
        } catch (Exception e) {
            log.error("[微信下单] 创建交易订单失败", e);
            return null;
        }

    }

    public void isSuccess(Map<String, String> result) {
        //判断通信标识
        String returnCode = result.get("return_code");
        if (WXPayConstants.FAIL.equals(returnCode)) {
            //通信失败
            log.error("[微信下单] 微信下单通信失败。失败原因:{ }", result.get("return_msg"));
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
        //判断业务表示
        String resultCode = result.get("result_code");
        if (WXPayConstants.FAIL.equals(resultCode)) {
            log.error("[微信下单] 微信下单通信失败,错误码{ },失败原因:{ }",
                    result.get("err_code"), result.get("err_code_des"));
            throw new CommonException(ExceptionEnum.PHONE_NUMBER_BE_NULL);
        }
    }

    public void isValidSign(Map<String, String> data) {
        try {
            //重新生成签名
            String sign1 = WXPayUtil.generateSignature(data, weChatPayConfig.getKey(), WXPayConstants.SignType.HMACSHA256);
            String sign2 = WXPayUtil.generateSignature(data, weChatPayConfig.getKey(), WXPayConstants.SignType.MD5);
            //和传过来的签名比较
            String sign = data.get("sign");
            if (!StringUtils.equals(sign, sign1) && !StringUtils.equals(sign, sign2)) {
                //签名有误，抛出异常
                throw new CommonException(ExceptionEnum.SIGN_IS_INCORRECT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
