package com.vcpf.jee202405110411.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
// 标识为数据库表，在类名与表名相同时可以省略
@Entity
// 声明为实体类，否则spring会报错
@Table(name = "user")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 标识为数据库主键
    private int id;
    @NotBlank(message = "用户名不能为空")
    private String uname;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Max(value = 120, message = "年龄不能大于120")
    @Min(value = 0, message = "年龄不能小于0")
    private Integer age;
    private String gender;
}
