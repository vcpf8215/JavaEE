package com.vcpf.jee202405110404.config;

import com.vcpf.jee202405110404.service.MyService;
import org.springframework.context.annotation.Bean;

public class BeanInitDestroyConfig {
    @Bean(initMethod = "initService", destroyMethod = "destroyService")
    public MyService getMyService() {
        return new MyService();
    }
}
