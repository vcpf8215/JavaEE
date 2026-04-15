package com.vcpf.iocdemo;

import java.util.HashMap;
import java.util.Map;

public class Container {
    // 做一个字典
    private Map<Class<?>, Object> beans = new HashMap<>();

    // 按键获取
    public <T> T getBean(Class<T> key) {
        return (T) beans.get(key);
    }

    // 置入键值
    public <T> void put(Class<T> key, T value) {
        beans.put(key, value);
    }
}
