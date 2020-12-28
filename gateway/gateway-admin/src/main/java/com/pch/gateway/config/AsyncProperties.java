package com.pch.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 异步配置属性
 *
 * @Author: pch
 * @Date: 2020/9/23
 */
@Getter
@Setter
@ConfigurationProperties("task.pool")
public class AsyncProperties {

    /**
     * 默认异步线程池
     */
    private BaseProperties taskProperties;

    @Getter
    @Setter
    public static class BaseProperties {

        private int corePoolSize;
        private int maxPoolSize;
        private int queueCapacity;
        private int keepAliveSeconds;
    }




}
