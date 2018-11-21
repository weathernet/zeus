package com.zcf.universe.common.wx;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuan
 * @date 2018/11/21 0021
 */
@Configuration
public class WeChatPayConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "wx.pay")
    public WeChatPayConfig weChatPayConfig() {
        return new WeChatPayConfig();
    }

    @Bean
    public WXPay wxPay(WeChatPayConfig weChatPayConfig) {
        return new WXPay(weChatPayConfig, WXPayConstants.SignType.HMACSHA256);
    }
}
