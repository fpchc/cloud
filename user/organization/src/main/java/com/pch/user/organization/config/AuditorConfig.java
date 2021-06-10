package com.pch.user.organization.config;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

/**
 * @Author: pch
 * @Date: 2020/9/10
 */
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Component("auditorAware")
public class AuditorConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System");
    }
}
