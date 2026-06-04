package com.vcpf.review.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Accessors(chain = true)
@Table(name = "user_table")
public class User {
    private String uName;
    private int uAge;
    private String uSex;
    private String uPassword;
}
