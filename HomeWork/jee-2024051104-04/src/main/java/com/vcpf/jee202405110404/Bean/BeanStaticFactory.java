package com.vcpf.jee202405110404.Bean;

public class BeanStaticFactory {
    private static BeanClass beanInstance = new BeanClass("调用静态工厂方法实例化Bean");

    public static BeanClass createInstance() {
        return beanInstance;
    }
}
