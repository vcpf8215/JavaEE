package com.vcpf.jee202405110412.entity;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 权限（编号，名称，用户列表）
 * 权限和用户之间，是多对多
 */
@Entity
@Table(name = "authority")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
public class Authority implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "authorityList")
    @JsonIgnore
    private List<User> userList;
}
