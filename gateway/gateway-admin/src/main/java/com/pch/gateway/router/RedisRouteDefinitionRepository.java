package com.pch.gateway.router;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pch.gateway.event.GatewayRouteEvent;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author: pch
 * @Date: 2020-12-12 11:10
 */
@Slf4j
@Component
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitions = new ArrayList<>();
        redisTemplate.opsForHash().values(GatewayRouteEvent.GATEWAY_ROUTES).forEach(routeDefinition ->
                routeDefinitions.add(JSON.parseObject(routeDefinition.toString(), RouteDefinition.class)));
        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            redisTemplate.opsForHash().put(GatewayRouteEvent.GATEWAY_ROUTES, routeDefinition.getId(), JSONObject.toJSONString(routeDefinition));
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            if (redisTemplate.opsForHash().hasKey(GatewayRouteEvent.GATEWAY_ROUTES, id)) {
                redisTemplate.opsForHash().delete(GatewayRouteEvent.GATEWAY_ROUTES, id);
                return Mono.empty();
            }
            return Mono.defer(() -> Mono.error(new NotFoundException("route definition is not found, routeId:" + id)));
        });
    }
}
