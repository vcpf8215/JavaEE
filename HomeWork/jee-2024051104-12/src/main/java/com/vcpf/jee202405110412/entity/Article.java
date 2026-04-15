package com.vcpf.jee202405110412.entity;
import java.io.Serializable;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * article(id,title,content,author)
 * 和author是多对一
 * 直接加外键：Author对象
 */
@Entity
@Table(name = "article_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
public class Article  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //标题
    @Column(nullable = false, length = 50)
    private String title;

    //文章内容 //大对象，映射 为MySQL的Long文本类型
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private String content;

    //所属作者，文章与作者是多对一的关系
    @ManyToOne(
            // 只支持刷新和更新级联
            cascade={CascadeType.MERGE,
                    CascadeType.REFRESH},
            // 文章必须有作者
            // 可选属性optional=false,表示author不能为空。删除文章，不影响用户
            optional=false)
    @JoinColumn(name="id_author_id")//设置在article表中的关联字段(外键)
    @JsonIgnore
    private Author author;
}
