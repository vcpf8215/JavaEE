package com.vcpf.jee202405110412.entity;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


/**
 * author(id,name,articleList)
 * 作者（编号，姓名，文章列表）
 * 和文章关系：一对多
 */
@Entity
@Table(name = "author_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
public class Author implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //作者名
    private String aname;
    //文章列表，作者与文章是一对多的关系
    @OneToMany(
            // 作者是被维护端，在文章处维护关系
            mappedBy = "author",
            // 支持所有级联操作
            cascade=CascadeType.ALL,
            // 关联的实体是文章
            targetEntity = Article.class,
            // 支持懒加载
            fetch=FetchType.LAZY
    )
    private List<Article> articleList;
}
