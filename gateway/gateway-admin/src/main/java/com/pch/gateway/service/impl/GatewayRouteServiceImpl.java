package com.pch.gateway.service.impl;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pch.gateway.event.GatewayRouteEvent;
import com.pch.gateway.event.GatewayRouteListener;
import com.pch.gateway.mapper.RouteRepository;
import com.pch.gateway.model.domain.GatewayRoutePo;
import com.pch.gateway.model.dto.GatewayRouteDto;
import com.pch.gateway.service.GatewayRouteService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2021/01/19 15:27
 */
@Slf4j
@Service
public class GatewayRouteServiceImpl implements GatewayRouteService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private RouteRepository routeRepository;

    @CreateCache(name = GatewayRouteEvent.GATEWAY_ROUTES, cacheType = CacheType.REMOTE)
    private Cache<String, RouteDefinition> gatewayRouteCache;

    @Override
    public Optional<GatewayRouteDto> get(String id) {
        Optional<GatewayRoutePo> gatewayRoutePo = routeRepository.findById(id);
        return gatewayRoutePo.map(this::getGatewayRouteDto);
    }

    private GatewayRouteDto getGatewayRouteDto(GatewayRoutePo gatewayRoutePo) {
        GatewayRouteDto gatewayRouteDto = new GatewayRouteDto();
        BeanUtils.copyProperties(gatewayRoutePo, gatewayRouteDto);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            gatewayRouteDto.setFilters(objectMapper.readValue(gatewayRoutePo.getFilters(), new TypeReference<>() {}));
            gatewayRouteDto.setPredicates(objectMapper.readValue(gatewayRoutePo.getPredicates(), new TypeReference<>() {}));
        } catch (JsonProcessingException e) {
            log.error("断言或者过滤器配置异常", e);
        }
        return gatewayRouteDto;
    }

    @Override
    @Transactional
    public String saveOrUpdate(GatewayRouteDto gatewayRouteDto) {
        GatewayRoutePo gatewayRoutePo = routeRepository.save(gatewayRouteDto.toPo());
        RouteDefinition routeDefinition = gatewayRouteToRouteDefinition(gatewayRoutePo);
        gatewayRouteCache.put(routeDefinition.getId(), routeDefinition);
        applicationContext.publishEvent(new GatewayRouteEvent(GatewayRouteListener.FIND_ALL_ACTION));
        return routeDefinition.getId();
    }

    @Override
    @Transactional
    public boolean delete(String id) {
        boolean isSuccess = this.delete(id);
        gatewayRouteCache.remove(id);
        applicationContext.publishEvent(new GatewayRouteEvent(GatewayRouteListener.FIND_ALL_ACTION));
        return isSuccess;
    }

    @Override
    public List<GatewayRouteDto> findAll() {
        List<GatewayRoutePo> gatewayRoutes = routeRepository.findAll();
        return gatewayRoutes.stream().map(this::getGatewayRouteDto).collect(Collectors.toList());
    }

    @Override
    @PostConstruct
    public boolean overload() {
        List<GatewayRoutePo> gatewayRoutes = routeRepository.findAll();
        gatewayRoutes.forEach(gatewayRoute ->
                gatewayRouteCache.put(gatewayRoute.getId(), gatewayRouteToRouteDefinition(gatewayRoute))
        );
        applicationContext.publishEvent(new GatewayRouteEvent(GatewayRouteListener.FIND_ALL_ACTION));
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
        routeDefinition.setId(gatewayRoutePo.getId());
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

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
