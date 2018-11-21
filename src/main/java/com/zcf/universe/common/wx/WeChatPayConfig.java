package com.zcf.universe.common.wx;

import com.github.wxpay.sdk.WXPayConfig;
import lombok.Data;

import java.io.InputStream;

/**
 * @author yuan
 * @date 2018/11/21 0021
 */
@Data
public class WeChatPayConfig implements WXPayConfig {
    //公众账号ID
    private String appID;
    //商户号
    private String mchID;
    //生成签名的秘钥
    private String key;
    //链接超时的时间
    private int httpConnectTimeoutMs;
    //读取超时时间
    private int httpReadTimeoutMs;
    //回调地址
    private String notifyUrl;

    @Override
    public InputStream getCertStream() {
        return null;
    }
}
