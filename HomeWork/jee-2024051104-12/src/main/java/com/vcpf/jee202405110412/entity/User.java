package com.vcpf.jee202405110412.entity;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 用户（编号，用户名，密码，权限列表）
 * 用户和权限列表之间，是多对多
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    /**
     * <pre>
     * 1、关系维护端，负责多对多关系的绑定和解除
     * 2、@JoinTable注解的name属性指定关联表的名字
     * 3、joinColumns指定外键的名字，关联到关系维护端（User）
     * 4、inverseJoinColumns指定外键的名字，需要关联的关系，称为被维护端（Authority）
     * 5、其实可以不使用@JoinTable注解
     *      默认生成的关联表名称为主表表名+下划线+从表表名，即表名为user_authority。
     *
     * 关联到主表的外键名：主表名+下划线+主表中的主键列名，即user_id。
     * 关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id。
     * 主表就是关系维护端对应的表，从表就是关系被维护端对应的表
     * </pre>
     */
    @ManyToMany
    @JoinTable(
            // 关联表名指定，双外键：用户和权限多对多
            // 将会在库里【创建第三张表】，由【用户】实体来维护
            name = "user_authority",
            // 在用户表里，也是外键，但认为用户是主表
            joinColumns = @JoinColumn(name = "user_id"),
            // 外键，但认为权限是从表
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorityList;
}
