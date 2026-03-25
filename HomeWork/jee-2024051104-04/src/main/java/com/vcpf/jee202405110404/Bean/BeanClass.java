package com.vcpf.jee202405110404.Bean;

import java.io.Serializable;

public class BeanClass implements Serializable {
    public String message;

    public BeanClass() {
        message = "构造方法实例化Bean";
    }

    public BeanClass(String s) {
        message = s;
    }
}
