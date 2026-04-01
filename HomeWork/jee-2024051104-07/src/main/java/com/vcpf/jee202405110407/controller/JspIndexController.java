package com.vcpf.jee202405110407.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.vcpf.jee202405110407.entity.Book;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器
 * <pre>
 *     1. 接请求
 *     2. 封装数据
 *     3. 导航到页面
 * </pre>
 */
@Controller
public class JspIndexController {

    @GetMapping("/")
    public String index(Model model) {
        List<Book> chenHeng = new ArrayList<Book>();
        Book teacherGeng = new Book(
                "9787302598503",99.8,
                "SSM + Spring Boot + Vue.js 3全栈开发从入门到实战",
                "清华大学出版社","陈恒","091883-01.jpg"
        );
        Book b1 = new Book(
                "9787302529118", 69.8,
                "Java Web开发从入门到实战（微课版）",
                "清华大学出版社", "陈恒","082526-01.jpg"
        );
        Book b2 = new Book(
                "9787302502968", 69.8,
                "Java EE框架整合开发入门到实战——Spring+Spring MVC+MyBatis（微课版）",
                "清华大学出版社", "陈恒","079720-01.jpg");
        chenHeng.add(b1);
        chenHeng.add(b2);
        // 单本
        model.addAttribute("aBook", teacherGeng);
        // 多本，列表
        model.addAttribute("books", chenHeng);
        return "index";
    }
}