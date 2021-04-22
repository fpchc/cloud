package com.pch.user.organization;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: pch
 * @Date: 2021/2/26
 */
@EnableAsync
@EnableJpaAuditing
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
@EnableCreateCacheAnnotation
@EnableTransactionManagement(proxyTargetClass = true)
@EnableMethodCache(basePackages = { "com.pch" })
public class OrganizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class, args);
    }

}
