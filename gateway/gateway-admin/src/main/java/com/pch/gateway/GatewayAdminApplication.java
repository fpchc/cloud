package com.pch.gateway;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.pch.common.util.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableJpaAuditing
@EnableScheduling
@EnableFeignClients(basePackages = "com.pch")
@EnableDiscoveryClient
@EnableCreateCacheAnnotation
@SpringBootApplication(scanBasePackages = { "com.pch" })
@EnableMethodCache(basePackages = { "com.pch", "org.springframework.cloud" })
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
