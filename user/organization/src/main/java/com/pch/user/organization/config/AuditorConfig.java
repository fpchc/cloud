package com.pch.user.organization.config;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() instanceof String) {
            return Optional.of("System");
        }
        if (authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();
            return Optional.of(user.getUsername());
        }
        return Optional.of("System");
    }
}
