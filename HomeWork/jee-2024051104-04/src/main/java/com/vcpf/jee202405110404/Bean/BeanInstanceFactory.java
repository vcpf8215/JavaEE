package com.vcpf.jee202405110404.Bean;

public class BeanInstanceFactory {
    public BeanClass createBeanClassInstance() {
        return new BeanClass("调用实例工厂方法实例化Bean");
    }
}
