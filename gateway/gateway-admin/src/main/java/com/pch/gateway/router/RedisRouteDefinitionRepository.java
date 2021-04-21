package com.pch.gateway.router;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.pch.gateway.event.GatewayRouteEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
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
    private StringRedisTemplate redisTemplate;

    @CreateCache(name = GatewayRouteEvent.GATEWAY_ROUTES, cacheType = CacheType.REMOTE)
    private Cache<String, RouteDefinition> gatewayRouteCache;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return getDefinitionFlux();
    }

    private Flux<RouteDefinition> getDefinitionFlux() {
        Set<String> routeKeys = getGatewayRouteKeys();
        if (CollectionUtils.isEmpty(routeKeys)) {
            return Flux.empty();
        }
        List<RouteDefinition> routeDefinitions = getRouteDefinitions(routeKeys);
        return Flux.fromIterable(routeDefinitions);
    }

    public List<RouteDefinition> getRouteDefinitions(Set<String> routeKeys) {
        Map<String, RouteDefinition> routeDefinitionMap = gatewayRouteCache.getAll(routeKeys);
        List<RouteDefinition> routeDefinitions = new ArrayList<>();
        routeDefinitionMap.values().forEach(routeDefinition -> {
            try {
                routeDefinition.setUri(new URI(routeDefinition.getUri().toASCIIString()));
            } catch (URISyntaxException e) {
                log.error("uri 不正确");
            }
            routeDefinitions.add(routeDefinition);
        });
        log.info("route info:{}", routeDefinitions);
        return routeDefinitions;
    }

    public Set<String> getGatewayRouteKeys() {
        Set<String> keys = redisTemplate.keys(GatewayRouteEvent.GATEWAY_ROUTES + "*");
        if (CollectionUtils.isEmpty(keys)) {
            return null;
        }
        return keys.stream().map(String -> String.replace(GatewayRouteEvent.GATEWAY_ROUTES, StringUtils.EMPTY))
                .collect(Collectors.toSet());
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return Mono.empty();
    }
}
