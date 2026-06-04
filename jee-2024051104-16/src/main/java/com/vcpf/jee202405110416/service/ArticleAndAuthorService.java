package com.vcpf.jee202405110416.service;

import java.util.ArrayList;
import java.util.List;
import com.vcpf.jee202405110416.entity.Author;
import org.springframework.ui.Model;


public interface ArticleAndAuthorService {
    /**
     * name代表作者名的一部分（模糊查询），sortColum代表排序列
     */
    List<Author> findByAnameContaining(String aname, String sortColum);
    /**
     * 分页查询作者，page代表第几页
     */
    public String findAllAuthorByPage(Integer page, Model model);

    // 多给一些测试数据
    public void saveAll();

}