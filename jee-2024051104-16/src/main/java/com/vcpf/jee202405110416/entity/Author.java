package com.vcpf.jee202405110416.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "author_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
public class Author implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //作者名
    private String aname;
    //文章列表，作者与文章是一对多的关系
    @OneToMany(
            mappedBy = "author",
            cascade=CascadeType.ALL,
            targetEntity = Article.class,
            fetch=FetchType.LAZY
    )
    private List<Article> articleList;
}
