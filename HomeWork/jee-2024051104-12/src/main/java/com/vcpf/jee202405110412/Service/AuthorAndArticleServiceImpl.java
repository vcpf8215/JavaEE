package com.vcpf.jee202405110412.Service;
import java.util.ArrayList;
import java.util.List;

import com.vcpf.jee202405110412.Repository.ArticleRepository;
import com.vcpf.jee202405110412.Repository.AuthorRepository;
import com.vcpf.jee202405110412.entity.Article;
import com.vcpf.jee202405110412.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorAndArticleServiceImpl implements AuthorAndArticleService{
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public void saveAll() {
        //保存作者（先保存一的一端）
        Author a1 = new Author();
        a1.setAname("郑伊伊1");
        Author a2 = new Author();
        a2.setAname("郑伊伊2");
        ArrayList<Author> allAuthor = new ArrayList<Author>();
        allAuthor.add(a1);
        allAuthor.add(a2);
        authorRepository.saveAll(allAuthor);
        //保存文章
        Article at1 = new Article();
        at1.setTitle("学习JPA是一件愉快的事情");
        at1.setContent("有了JAVA基础，应该学习一下JAVAEE+JPA，方便数据库操作");
        //设置关系
        at1.setAuthor(a1);
        Article at2 = new Article();
        at2.setTitle("学习JPA是一件幸福的事情");
        at2.setContent("有了JAVA基础，应该学习一下JAVAEE+JPA，方便数据库操作");
        //设置关系
        at2.setAuthor(a1);//文章2与文章1作者相同
        Article at3 = new Article();
        at3.setTitle("学习JPA是一件需要多实践的事情");
        at3.setContent("有了JAVA基础，应该学习一下JAVAEE+MBP，方便数据库操作");
        //设置关系
        at3.setAuthor(a2);
        Article at4 = new Article();
        at4.setTitle("学习JPA是一件需要多练习的事情");
        at4.setContent("有了JAVA基础，应该学习一下JAVAEE+MBP，方便数据库操作");
        //设置关系
        at4.setAuthor(a2);//文章3与文章4作者相同
        ArrayList<Article> allAt = new ArrayList<Article>();
        allAt.add(at1);
        allAt.add(at2);
        allAt.add(at3);
        allAt.add(at4);
        articleRepository.saveAll(allAt);
    }
    @Override
    public List<Article> findByAuthor_id(Integer id) {
        return articleRepository.findByAuthor_id(id);
    }
    @Override
    public List<Article> findByAuthor_aname(String aname) {
        return articleRepository.findByAuthor_aname(aname);
    }
    @Override
    public Author findByArticleList_titleContaining(String title) {
        return authorRepository.findByArticleList_titleContaining(title);
    }
}
