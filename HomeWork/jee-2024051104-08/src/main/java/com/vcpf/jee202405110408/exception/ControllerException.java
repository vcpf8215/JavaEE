package com.vcpf.jee202405110408.exception;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import java.util.HashMap;

@ControllerAdvice
public class ControllerException {

    private final View error;

    public ControllerException(View error) {
        this.error = error;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleValidException(MethodArgumentNotValidException e) {
        //将错误信息返回给前台
        String field; 	// 字段
        String msg;		// 消息

        // 封装成errors的JSON对象
        HashMap<String, Object> errors = new HashMap<>();
        HashMap<String, String> errorMessage = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            // 获取错误验证字段名
            field = fieldError.getField();
            msg = fieldError.getDefaultMessage();
            // 调整格式
            errorMessage.put(field, msg);
        }
        errors.put("code", "600001");
        errors.put("msg", "数据校验出错");
        errors.put("errorsMessage", errorMessage);
        return errors;
    }
}