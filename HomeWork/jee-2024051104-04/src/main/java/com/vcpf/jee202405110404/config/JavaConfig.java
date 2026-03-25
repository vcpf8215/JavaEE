package com.vcpf.jee202405110404.config;

import com.vcpf.jee202405110404.Bean.BeanClass;
import com.vcpf.jee202405110404.Bean.BeanInstanceFactory;
import com.vcpf.jee202405110404.Bean.BeanStaticFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean(value = "beanClass")
    public BeanClass getBeanClass() {
        return new BeanClass();
    }

    @Bean(value = "beanStaticFactory")
    public BeanClass getBeanStaticFactory() {
        return BeanStaticFactory.createInstance();
    }

    @Bean(value = "beanInstanceFactory")
    public BeanClass getBeanInstanceFactory() {
        BeanInstanceFactory bi = new BeanInstanceFactory();
        return bi.createBeanClassInstance();

        // return new BeanInstanceFactory().createBeanClassInstance();
    }
}
