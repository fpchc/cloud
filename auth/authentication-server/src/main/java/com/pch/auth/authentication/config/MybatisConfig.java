package com.pch.auth.authentication.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.pch.common.config.AuditorMetaObjectHandler;
import com.pch.common.config.UserInfoInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: pch
 * @Date: 2021/5/24 10:30
 */
@Configuration
@MapperScan("com.pch.auth.authentication.dao")
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfig {

    /**
     * 分页插件 新版分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public AuditorMetaObjectHandler getAuditorMetaObjectHandler() {
        return new AuditorMetaObjectHandler();
    }

    @Bean
    public UserInfoInterceptor getUserInfoInterceptor() {
        return new UserInfoInterceptor();
    }


}
