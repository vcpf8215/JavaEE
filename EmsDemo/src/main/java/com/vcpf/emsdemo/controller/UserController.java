package com.vcpf.emsdemo.controller;

import com.vcpf.emsdemo.entity.User;
import com.vcpf.emsdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 访问页面
 * 到达主页 http://localhost:8080/ems/user/index
 * 到达注册页 http://localhost:8080/ems/user/login
 * 到达登录页 http://localhost:8080/ems/user/regist
 */
@Controller  // 以下class就是一个控制器，任意class和method都可以当控制
@RequestMapping("/user")  // 如何到达这个控制器
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    // 以下是多种控制路由，所有视图，从控制器到达
    @RequestMapping("/index")
    public String index() {
        // 做导航
        return "/index";
    }

    @RequestMapping("/regist")
    public String userRegist() {
        // 做导航
        return "/user/regist";
    }

    @RequestMapping("/login")
    public String userLogin() {
        // 做导航
        return "/user/login";
    }

    @RequestMapping("/exit")
    public String userExit(HttpSession session, RedirectAttributes redirectAttr) {

        // 让session失效，即登录里的session信息清空
        session.invalidate();
        // 带给前端一些提示信息
        redirectAttr.addFlashAttribute("message","退出成功，欢迎下次登录！");
        // 做导航
        return "redirect:/user/login";
    }


    /**
     * <pre>
     *     完成用户注册
     *      1. 接收用户请求参数
     *      2. 封装成user对象
     *      3. 调userService业务，完成注册，即添加用户，保存好用户信息
     *      4. 跳转到登录页
     * </pre>
     *
     * @param user
     * @return
     */
    @RequestMapping("/regist.do")
    public String userRegistAction(User user, RedirectAttributes redirectAttr) {
        // 请思考，这是控制器该干的事情么？
        String id = UUID.randomUUID().toString();
        user.setId(id);
        log.info(user.toString());
        try {
            // 调业务
            userService.save(user);
        } catch (Exception e) {
            // 暂不做异常处理，打印即可
            e.printStackTrace();
            // 未成功注册，则再重试
            redirectAttr.addFlashAttribute("message","未成功注册，请重试");
            return "redirect:/user/regist";
        }
        // 成功注册，则重定向到登录，做跳转
        redirectAttr.addFlashAttribute("message","成功注册，请登录");
        return "redirect:/user/login";
    }

    /**
     * <pre>
     *     完成用户登录
     *      1. 接收用户请求参数：用户名和密码
     *      2. 调userService业务，完成登录判断
     *      3. 跳转到登录页
     * </pre>
     */
    @RequestMapping("/login.do")
    public String userLoginAction(
            String username, String password,
            HttpSession session,
            RedirectAttributes redirectAttr) {
        try {
            // 1 直接拿参数，调业务
            User user = userService.findUserByUsernameAndPassword(username,password);
            // 2.1 登录正常，这里肯定要写用户的session信息，以便后续业务判断用户是否已经登录
            if (user != null) {
                session.setAttribute("user", user);
                return "redirect:/emp/main";
            } else {
                redirectAttr.addFlashAttribute("message","用户名或密码不对，请重试");
                return "redirect:/user/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 2.2 登录异常
            redirectAttr.addFlashAttribute("message","登录异常，请重新登录");
            return "redirect:/user/login";
        }
        // 3 做导航跳转
//        return "redirect:/user/login";
        // 4 作为控制器，不要做多余的动作！！！！！
    }

}