package com.pch.gateway.service.impl;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pch.gateway.mapper.RouteMapper;
import com.pch.gateway.model.domain.GatewayRoutePo;
import com.pch.gateway.model.dto.GatewayRouteDto;
import com.pch.gateway.service.GatewayRouteService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2021/01/19 15:27
 */
@Service
@Slf4j
public class GatewayRouteServiceImpl extends ServiceImpl<RouteMapper, GatewayRoutePo>
        implements GatewayRouteService {

    private static final String GATEWAY_ROUTES = "gateway_routes::";

    @CreateCache(name = GATEWAY_ROUTES, cacheType = CacheType.REMOTE)
    private Cache<String, RouteDefinition> gatewayRouteCache;

    @Override
    public GatewayRouteDto get(String id) {
        GatewayRoutePo gatewayRoutePo = this.getById(id);

        return null;
    }

    @Override
    public boolean add(GatewayRouteDto gatewayRouteDto) {
        boolean isSuccess = this.save(gatewayRouteDto.toPo());
        RouteDefinition routeDefinition = gatewayRouteToRouteDefinition(gatewayRouteDto.toPo());
        gatewayRouteCache.put(routeDefinition.getId(), routeDefinition);
        return isSuccess;
    }

    @Override
    public boolean update(GatewayRouteDto gatewayRouteDto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        boolean isSuccess = this.delete(id);
        gatewayRouteCache.remove(id);
        return isSuccess;
    }

    @Override
    @PostConstruct
    public boolean overload() {
        List<GatewayRoutePo> gatewayRoutes = this.list(new QueryWrapper<>());
        gatewayRoutes.forEach(gatewayRoute ->
                gatewayRouteCache.put(gatewayRoute.getRouteId(), gatewayRouteToRouteDefinition(gatewayRoute))
        );
        log.info("全局初使化网关路由成功!");
        return true;
    }

    /**
     * 将数据库中json对象转换为网关需要的RouteDefinition对象
     *
     * @param gatewayRoutePo
     * @return RouteDefinition
     */
    private RouteDefinition gatewayRouteToRouteDefinition(GatewayRoutePo gatewayRoutePo) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(gatewayRoutePo.getRouteId());
        routeDefinition.setOrder(gatewayRoutePo.getOrders());
        routeDefinition.setUri(URI.create(gatewayRoutePo.getUri()));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            routeDefinition.setFilters(objectMapper.readValue(gatewayRoutePo.getFilters(), new TypeReference<>() {}));
            routeDefinition.setPredicates(objectMapper.readValue(gatewayRoutePo.getPredicates(), new TypeReference<>() {}));
        } catch (IOException e) {
            log.error("网关路由对象转换失败", e);
        }
        return routeDefinition;
    }
}
