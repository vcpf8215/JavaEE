package com.vcpf.jee202405110412.entity;
import java.io.Serializable;
import java.util.Calendar;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


/**
 * 身份证（编号，身份证号码，生日，住址，所属人）
 * 身份证-所属人 是一对一关联
 * @author vcpf
 */
@Entity
@Table(name = "idcard_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
public class IdCard implements Serializable{

    /**
     * 自动递增的主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    /**
     * 生日<pre>
     * @Temporal主要是用来指明java.util.Date 或 java.util.Calendar 类型的属性具体
     * 与数据库（date、time、timestamp）三个类型中的那一个进行映射</pre>
     */
    @Temporal(value = TemporalType.DATE)
    private Calendar birthday;

    private String address;

    /**
     * 对应的人
     * <pre>
     * optional = false设置person属性值不能为null，也就是身份证必须有对应的主人。
     * mappedBy = "idCard"与Person类中的idCard属性一致
     * 拥有mappedBy注解的实体类为关系的被维护端。</pre>
     */
    @OneToOne(
            // 不可为空，即卡必须有人
            optional = false,
            // 懒加载
            fetch = FetchType.LAZY,
            // 关联实体
            targetEntity = Person.class,
            // 卡是被人维护的
            mappedBy = "idCard",
            // 级联所有操作CRUD
            cascade = CascadeType.ALL
    )
    private Person person;
}
