package com.zcf.universe.controller.console;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "login";
    }

    @GetMapping("/test")
    public String Test() {
        return "Test";
    }

    @GetMapping("/webSocket")
    public String webSocket() {
        return "websocket";
    }
}
