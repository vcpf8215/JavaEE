package com.vcpf.jee202405110406.Controller;

import com.vcpf.jee202405110406.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

/**
 * 全局异常处理器，切面
 * <pre>
 *     定义后，它会自动织入
 * </pre>
 * @author zfh
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {

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
}