package com.pch.auth.authentication.config;

import feign.Feign;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * @Author: pch
 * @Date: 2021/4/22 9:49
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOKHttpConfig {

    @Bean
    public okhttp3.OkHttpClient okHttpClient(){
        return new okhttp3.OkHttpClient.Builder()
                //设置连接超时
                .connectTimeout(60, TimeUnit.SECONDS)
                //设置读超时
                .readTimeout(60, TimeUnit.SECONDS)
                //设置写超时
                .writeTimeout(120,TimeUnit.SECONDS)
                //是否自动重连
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool())
//                .addInterceptor(new OkHttpLogInterceptor())
                //构建OkHttpClient对象
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }

}
