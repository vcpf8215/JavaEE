package com.vcpf.jee202405110411.Controller;

import com.vcpf.jee202405110411.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vcpf
 */
@Controller
public class UserTestController {

    @Autowired
    private UserService userService;

    // http://localhost:8080/ch6_1/save
    @GetMapping("/save")
    @ResponseBody
    public String save() {
        userService.saveAll();
        return "保存用户成功！";
    }

    // http://localhost:8080/ch6_1/findByUname?uname=陈恒1
    @GetMapping("/findByUname")
    public String findByUname(String uname, Model model) {
        model.addAttribute("title", "根据用户名查询一个用户");
        model.addAttribute("auser", userService.findByUname(uname));
        return "showAuser.html";
    }

    // http://localhost:8080/ch6_1/getOne?id=1
    @GetMapping("/getOne")
    public String getOne(int id, Model model) {
        model.addAttribute("title", "根据用户id查询一个用户");
        model.addAttribute("auser",userService.getOne(id));
        return "showAuser.html";
    }

    // http://localhost:8080/ch6_1/findAll
    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("title", "查询所有用户");
        model.addAttribute("allUsers",userService.findAll());
        return "showAll";
    }

    // http://localhost:8080/ch6_1/findByUnameLike?uname=陈
    @GetMapping("/findByUnameLike")
    public String findByUnameLike(String uname, Model model){
        model.addAttribute("title", "根据用户名模糊查询所有用户");
        model.addAttribute("allUsers",userService.findByUnameLike(uname));
        return "showAll";
    }
}