package com.vcpf.jee202405110416.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Table(name = "article_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
public class Article  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //标题
    @Column(nullable = false, length = 50)
    private String title;
    //文章内容
    @Lob  //大对象，映射 为MySQL的Long文本类型
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private String content;
    //所属作者，文章与作者是多对一的关系
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    //可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="id_author_id")//设置在article表中的关联字段(外键)
    @JsonIgnore
    private Author author;
}
