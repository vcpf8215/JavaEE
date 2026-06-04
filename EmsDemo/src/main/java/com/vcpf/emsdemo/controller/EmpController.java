package com.vcpf.emsdemo.controller;

import com.vcpf.emsdemo.entity.Emp;
import com.vcpf.emsdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/main")
    public String empMain(Model m,
                          HttpSession session,
                          RedirectAttributes redirectAttr) {
        // 1. 检查session，是登录状态，才可查看到数据
        // http://localhost:8080/ems/emp/main 直接访问，会跳转到登录页
        Object user = session.getAttribute("user");
        if (ObjectUtils.isEmpty(user)) {
            redirectAttr.addFlashAttribute("message","请登录后进行员工管理");
            return "redirect:/user/login";
        } else {
            List<Emp> emps = empService.findAll();
            m.addAttribute("emps", emps);
            return "/emp/main";
        }
    }

    @RequestMapping("/add")
    public String empAdd() {
        return "/emp/add";
    }

    @RequestMapping("/edit")
    public String empEdit(String id,Model m) {
        Emp emp = empService.findEmpById(id);
//		System.out.println("emp id:"+id);
        m.addAttribute("emp", emp);
        return "/emp/edit";
    }

    @RequestMapping("/add.do")
    public String empAddAction(Emp emp) {
        try {
            empService.save(emp);
            return "redirect:/emp/main";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/emp/main";
    }

    @RequestMapping("/edit.do")
    public String empEditAction(Emp emp) {
        try {
            empService.alter(emp);
            return "redirect:/emp/main";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/emp/main";
    }

    @RequestMapping("/del")
    public String empDelAction(String id) {
        try {
            empService.remove(id);
            return "redirect:/emp/main";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/emp/main";
    }
}