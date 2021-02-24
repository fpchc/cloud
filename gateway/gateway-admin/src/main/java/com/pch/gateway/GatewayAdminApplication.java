package com.pch.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.pch.common.util.SpringContextHolder;

@EnableAsync
@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication
@EnableDiscoveryClient
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = { "com.pch" })
public class GatewayAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayAdminApplication.class, args);
    }

    @Primary
    @Bean
    public SpringContextHolder getSpringContextHolder() {
        return new SpringContextHolder();
    }

}
