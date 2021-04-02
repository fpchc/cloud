package com.pch.auth.authentication.client.config;

import feign.Feign;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
@ConditionalOnClass(Feign.class)
public class FeignOkHttpConfig {

    private static final int feignOkHttpReadTimeout = 60;
    private static final int feignConnectTimeout = 60;
    private static final int feignWriteTimeout = 120;

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
            .readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
            .connectTimeout(feignConnectTimeout, TimeUnit.SECONDS)
            .writeTimeout(feignWriteTimeout, TimeUnit.SECONDS)
//				.connectionPool(new ConnectionPool(int maxIdleConnections, long keepAliveDuration, TimeUnit timeUnit))   //自定义链接池
//				.addInterceptor(XXXXXXXInterceptor) 	//自定义拦截器
            .build();
    }

}
