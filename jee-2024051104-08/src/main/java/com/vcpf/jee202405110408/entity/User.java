package com.vcpf.jee202405110408.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    @NotBlank(message = "用户名不能为空")
    private String name;
    @Min(value = 1, message = "年龄不能小于1岁")
    @Max(value = 120, message = "年龄不能大于120岁")
    private Integer age;
    @Email(message = "邮箱格式不正确")
    private String email;
    @Past(message = "生日不能晚于当前时间")
    private LocalDate birthday;
}