package com.vcpf.jee202405110409.controller;

import com.vcpf.jee202405110409.entity.User;
import com.vcpf.jee202405110409.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    private User isLogin(User user) {
        User loginUser = userService.getUser(user);
        log.info("loginUser:{}", loginUser);
        return loginUser;
    }

    // http://localhost:8080/login
    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        // 处理登录逻辑
//        if ("fhzheng".equals(user.getName()) && "123456".equals(user.getPassword())){
//            session.setAttribute("user", user);
//            log.info("用户登录成功");
//            return "main";
//        }
        User login = isLogin(user);
        if (!ObjectUtils.isEmpty(login)) {
            session.setAttribute("user", login);
            log.info("用户登录成功");
            return "main";
        }
        else {
            log.info("用户登录失败");
            model.addAttribute("msg","用户名或密码错误，请重新登录");
            return "forward:/tologin";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "forward:/tologin";
    }
}
