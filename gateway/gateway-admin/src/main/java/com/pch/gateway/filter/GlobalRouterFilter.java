package com.pch.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pch.auth.authentication.client.service.AuthService;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <P> 路由全局拦截器 </P>
 *
 * @Author: pch
 * @Date: 2020/12/12 9:57
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class GlobalRouterFilter implements GlobalFilter, Ordered {

    public static final String CLIENT_TOKEN_USER = "clientUser";

    private final AuthService authService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        long requestStartTime = System.currentTimeMillis();
        ServerHttpRequest request = exchange.getRequest();
        String authorization = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String url = request.getURI().getRawPath();
        HttpMethod method = request.getMethod();
        log.info("请求url: {}, method: {}, 请求header: {}, 请求时间: {}ms", url, method, request.getHeaders(),
                System.currentTimeMillis() - requestStartTime);
        if (authService.ignoreUrls(url)) {
            return chain.filter(exchange);
        }
        if (authService.authentication(authorization, url, method)) {
            ServerHttpRequest.Builder builder = request.mutate();
            //TODO 转发的请求都加上服务间认证token
//            builder.header(X_CLIENT_TOKEN, "TODO zhoutaoo添加服务间简单认证");
//            //将jwt token中的用户信息传给服务
            builder.header(CLIENT_TOKEN_USER, getUserToken(authorization));
            return chain.filter(exchange.mutate().request(builder.build()).build());
        }
        return unauthorized(exchange);
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer dataBuffer = exchange.getResponse().bufferFactory()
                .wrap(HttpStatus.UNAUTHORIZED.getReasonPhrase().getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Flux.just(dataBuffer));
    }

    private String getUserToken(String authorization) {
        try {
            return new ObjectMapper().writeValueAsString(authService.getJwtToken(authorization));
        } catch (JsonProcessingException e) {
            log.error("json转换异常", e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
