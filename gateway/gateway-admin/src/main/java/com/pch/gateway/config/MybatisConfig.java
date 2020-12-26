package com.pch.gateway.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.pch.common.base.BaseMateObjectHandle;
import com.pch.common.base.IdGenerator;

/**
 * <P> mybatis plus 配置类 </P>
 *
 * @Author: pch
 * @Date: 2020-12-20 13:58
 */
@Configuration
@MapperScan("com.pch.gateway.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfig {

    public static final Integer GATEWAY_WORK_ID = 1;
    public static final Integer GATEWAY_DATACENTER_ID = 1;

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
    public IdentifierGenerator gatewayIdGenerator() {
        return new IdGenerator(GATEWAY_WORK_ID, GATEWAY_DATACENTER_ID);
    }

    @Bean
    public BaseMateObjectHandle gatewayBaseMateObjectHandle() {
        return new BaseMateObjectHandle();
    }


}
