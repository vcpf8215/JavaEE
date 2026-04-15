package com.vcpf.jee202405110412.Controller;
import java.util.List;

import com.vcpf.jee202405110412.Service.AuthorAndArticleService;
import com.vcpf.jee202405110412.entity.Article;
import com.vcpf.jee202405110412.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 作者和文章：一对多，一个人可写多篇文章，一篇文章只被一人与
 * 1. 初始化数据
 * 2. 查询所有
 * </pre>
 */
@RestController
public class TestOneToManyController {

    @Autowired
    private AuthorAndArticleService authorAndArticleService;

    // http://localhost:8080/ch6_2/saveOneToMany
    @GetMapping("/saveOneToMany")
    public String save() {
        authorAndArticleService.saveAll();
        return "作者和文章保存成功！";
    }

    // http://localhost:8080/ch6_2/findArticleByAuthor_id?id=2
    @GetMapping("/findArticleByAuthor_id")
    public List<Article> findByAuthor_id(Integer id) {
        return authorAndArticleService.findByAuthor_id(id);
    }

    // http://localhost:8080/ch6_2/findArticleByAuthor_aname?aname=陈恒1
    @GetMapping("/findArticleByAuthor_aname")
    public List<Article> findByAuthor_aname(String aname){
        return authorAndArticleService.findByAuthor_aname(aname);
    }

    // http://localhost:8080/ch6_2/findByArticleList_titleContaining?title=JPA的一对多111
    @GetMapping("/findByArticleList_titleContaining")
    public Author findByArticleList_titleContaining(String title) {
        return authorAndArticleService.findByArticleList_titleContaining(title);
    }
}
