package com.pch.gateway.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.pch.gateway.config.AsyncProperties.BaseProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * 配置异步自定义线程池
 * @author: pch
 * @date: 2020/9/23
 */
@Slf4j
@Configuration
public class AsyncTaskExecutePool {

    @Autowired
    private AsyncProperties asyncProperties;

    @Bean
    public AsyncProperties getAsyncPorpoise() {
        return new AsyncProperties();
    }

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        BaseProperties taskProperties = asyncProperties.getTaskProperties();
        //核心线程池大小
        executor.setCorePoolSize(taskProperties.getCorePoolSize());
        //最大线程数
        executor.setMaxPoolSize(taskProperties.getMaxPoolSize());
        //队列容量
        executor.setQueueCapacity(taskProperties.getQueueCapacity());
        //活跃时间
        executor.setKeepAliveSeconds(taskProperties.getKeepAliveSeconds());
        //线程名字前缀
        executor.setThreadNamePrefix("pch-async-");
        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}
