package com.vcpf.jee202405110416.service;

import java.util.ArrayList;
import java.util.List;
import com.vcpf.jee202405110416.entity.Author;
import com.vcpf.jee202405110416.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class ArticleAndAuthorServiceImpl implements ArticleAndAuthorService{
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Override
    public List<Author> findByAnameContaining(String aname, String sortColum) {
        //按sortColum降序排序
        return authorRepository.findByAnameContaining(aname, Sort.by(Direction.DESC, sortColum));
    }
    
    @Override
    public String findAllAuthorByPage(Integer page, Model model) {
        if(page == null) {//第一次访问findAllAuthorByPage方法时
            page = 1;
        }
        int size = 2;//每页显示2条
        //分页查询，of方法的第一个参数代表第几页（比实际小1），
        //第二个参数代表页面大小，第三个参数代表排序规则
        Page<Author> pageData =
                authorRepository.findAll(PageRequest.of(page-1, size, Sort.by(Direction.DESC, "id")));
        //获得当前页面数据并转换成List<Author>，转发到视图页面显示
        List<Author> allAuthor = pageData.getContent();
        model.addAttribute("allAuthor",allAuthor);
        //共多少条记录
        model.addAttribute("totalCount", pageData.getTotalElements());
        //共多少页
        model.addAttribute("totalPage", pageData.getTotalPages());
        //当前页
        model.addAttribute("page", page);
        return "index";
    }

    // 多给一些测试数据
    @Override
    public void saveAll() {
        //保存作者（保存一的一端）
        ArrayList<Author> allAuthor = new ArrayList<Author>();
        Author a1 ;
        for (int i = 0; i < 10; i++) {
            a1 = new Author();
            a1.setAname("陈测自" + i);
            allAuthor.add(a1);
        }
        authorRepository.saveAll(allAuthor);
    }
}
