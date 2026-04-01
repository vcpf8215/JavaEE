package com.vcpf.jee202405110408.controller;

import com.vcpf.jee202405110408.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    /**
     * <pre>
     *     请求方式： 发起post请求
     *     地址： http://localhost:8080/requestbody
     *     正常响应： User的JSON
     *     异常响应： 也是JSON
     *          在errors键里面，可见出错提示
     *              objectName      - 对象名
     *              defaultMessage  - 提示信息
     *              rejectedValue   - 字段的值
     *              field           - 字段
     * </pre>
     * @param user
     * @return
     */
    @PostMapping("/requestbody")
    public User requestBody(@RequestBody @Valid User user) {
        return user;
    }
}