package com.pch.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * <P> 路由全局拦截器 </P>
 *
 * @Author: pch
 * @Date: 2020/12/12 9:57
 */
@Component
public class GlobalRouterFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
