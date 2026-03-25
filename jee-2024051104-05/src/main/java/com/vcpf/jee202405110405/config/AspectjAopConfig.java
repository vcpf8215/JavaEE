package com.vcpf.jee202405110405.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.vcpf.jee202405110405")
@EnableAspectJAutoProxy
public class AspectjAopConfig {
}
