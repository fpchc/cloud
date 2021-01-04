package com.pch.gateway.config;

import java.net.URI;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * <P> 路由全局拦截器 </P>
 *
 * @Author: pch
 * @Date: 2020/12/12 9:57
 */
@Slf4j
@Component
public class GlobalRouterFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authorization = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String url = request.getPath().value();
        HttpMethod method = request.getMethod();
        exchange.getAttributes().put("requestTimeBegin", System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute("requestTimeBegin");
                    if (startTime != null) {
                        log.info(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
