package com.vcpf.jee202405110418jpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;

/**
 * @Table(indexes = {@Index(name = "uk_email",columnList = "email",unique = true)})
 *      创建表时，创建索引，索引列是email,索引键名，唯一索引
 * @Column(nullable = false,columnDefinition = "varchar(20) comment '姓名'")
 *      创建表时，创建该列，不允许为空，详细定义为串，默认注释为 '姓名'
 * @Transient 对该列不做映射
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(indexes = {@Index(name = "uk_email",columnList = "email",unique = true)})
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,columnDefinition = "varchar(20) comment '姓名'")
    private String name;

    @Transient
    private int age;

    @Column(nullable = false,length = 50)
    private String email;

    private LocalDate birthDay;

}