package com.vcpf.jee202405110409.controller;

import com.vcpf.jee202405110409.entity.User;
import com.vcpf.jee202405110409.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class RegistController {

    @Autowired
    private UserService userService;

    // 到达注册页面
    // http://localhost:8080/register
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    // 完成注册提交
    @RequestMapping("/regist")
    public String regist(User user) {
        log.info("regist user:{}", user);
        // 注册业务处理
        boolean res = userService.addUser(user);
        if (res) {
            log.info("用户注册成功");
            return "redirect:/tologin";
        } else {
            log.info("用户注册失败");
            return "register";
        }
    }

    // 转发到login页面
    @RequestMapping("/tologin")
    public String login() {
        return "login";
    }
}
