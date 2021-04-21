package com.pch.gateway.config;

import com.pch.gateway.config.AsyncProperties.BaseProperties;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 配置异步自定义线程池
 *
 * @Author: pch
 * @Date: 2020/9/23
 */
@Slf4j
@EnableAsync
@Configuration
public class AsyncTaskExecutePool {

    @Bean
    public AsyncProperties getAsyncPorpoise() {
        return new AsyncProperties();
    }

    @Bean("taskExecutor")
    @ConditionalOnBean(name = "asyncProperties")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        BaseProperties taskProperties = getAsyncPorpoise().getTaskProperties();
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
