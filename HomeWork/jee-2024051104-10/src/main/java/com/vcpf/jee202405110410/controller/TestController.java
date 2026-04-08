package com.vcpf.jee202405110410.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test01")
    public String test01() {
        return "test01";
    }
}