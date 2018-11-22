package com.zcf.universe.controller.api;

import com.zcf.universe.common.wx.WeChatPAyHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan
 * @date 2018/11/21 0021
 */
@RestController
public class TestController {
    @Autowired
    private WeChatPAyHelp help;

    @PostMapping(value = "WeChatPay", produces = "application/xml;charset=UTF-8")
    public void Test() {
        String order = help.createOrder();
    }
}
