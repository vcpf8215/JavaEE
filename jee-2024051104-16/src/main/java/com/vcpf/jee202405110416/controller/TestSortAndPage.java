package com.vcpf.jee202405110416.controller;


import java.util.List;

import com.vcpf.jee202405110416.entity.Author;
import com.vcpf.jee202405110416.service.ArticleAndAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestSortAndPage {
    
    @Autowired
    private ArticleAndAuthorService articleAndAuthorService;
    
    @GetMapping("/findByAnameContaining")
    @ResponseBody
    public List<Author> findByAnameContaining(String aname, String sortColum){
        return articleAndAuthorService.findByAnameContaining(aname, sortColum);
    }
    
    @GetMapping("/findAllAuthorByPage")
    public String findAllAuthorByPage(Integer page, Model model){
        return articleAndAuthorService.findAllAuthorByPage(page, model);
    }

    // http://localhost:8080/ch6_3/add
    @GetMapping("/add")
    @ResponseBody
    public String add(){
        articleAndAuthorService.saveAll();
        return "存入10个作者信息";
    }
}
