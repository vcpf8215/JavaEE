package com.vcpf.jee202405110412.Service;
import com.vcpf.jee202405110412.entity.Article;
import com.vcpf.jee202405110412.entity.Author;

import java.util.List;

public interface AuthorAndArticleService {
    public void saveAll();
    public List<Article> findByAuthor_id(Integer id);
    public List<Article> findByAuthor_aname(String aname);
    public Author findByArticleList_titleContaining(String title);
}
