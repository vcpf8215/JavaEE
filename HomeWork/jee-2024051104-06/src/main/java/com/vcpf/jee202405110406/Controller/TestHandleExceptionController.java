package com.vcpf.jee202405110406.Controller;

import com.vcpf.jee202405110406.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class TestHandleExceptionController {

    // http://localhost:8080/ch5_3
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 用注解方式，做异常处理器
    // 一旦捕获异常，则返回视图，做导航用
    @ExceptionHandler(value=Exception.class)
    public String handlerException(Exception e) {
        //数据库异常
        if (e instanceof SQLException) {
            return "sqlError";
            //自定义异常
        } else if (e instanceof MyException) {
            return "myError";
            //未知异常
        } else {
            return "noError";
        }
    }
    @GetMapping("/db")
    public void db() throws SQLException {
        throw new SQLException("数据库异常");
    }
    @GetMapping("/my")
    public void my() throws MyException {
        throw new MyException("自定义异常");
    }
    @GetMapping("/no")
    public void no() throws Exception {
        throw new Exception("未知异常");
    }
}