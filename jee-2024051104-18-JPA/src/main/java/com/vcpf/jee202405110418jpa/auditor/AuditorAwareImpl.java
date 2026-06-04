package com.vcpf.jee202405110418jpa.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 加入审审计人员信息，真实的项目中，替换为登录用户即可
 * 接口实现类：在审计功能里提供当前的审计者信息
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // 模拟添加一个随机数，相当于随机给出一个审计人信息
        return Optional.of("管理员" + (int) (Math.random() * 10));
    }
}