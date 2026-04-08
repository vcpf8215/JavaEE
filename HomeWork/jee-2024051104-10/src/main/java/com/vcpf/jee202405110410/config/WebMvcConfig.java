package com.vcpf.jee202405110410.config;

import com.vcpf.jee202405110410.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {

    private final MyInterceptor myInterceptor;

    // 建议用构造器注入拦截器，再做配置
    @Autowired
    public WebMvcConfig(MyInterceptor myInterceptor) {
        this.myInterceptor = myInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
//        .excludePathPatterns("/index.jsp")
//        .order("指定执行顺序")
        ;
    }
}