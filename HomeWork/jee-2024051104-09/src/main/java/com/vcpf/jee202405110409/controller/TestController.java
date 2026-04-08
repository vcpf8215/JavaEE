package com.vcpf.jee202405110409.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    // 直接返回字符串的处理器
    // http://localhost:8080/test01
    @RequestMapping("/test01")
    @ResponseBody
    public String test() {
        return "test01 测试控制器";
    }

    // 返回视图，到达JSP页面
    // http://localhost:8080/test02
    @RequestMapping("/test02")
    public String index() {
        return "index";
    }
}
