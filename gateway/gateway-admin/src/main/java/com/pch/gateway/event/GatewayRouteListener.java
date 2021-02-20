package com.pch.gateway.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.pch.gateway.router.RedisRouteDefinitionRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2020-12-20 13:31
 */
@Slf4j
@Async
@Component
public class GatewayRouteListener {

    public static final String SAVE_ACTION = "save";

    public static final String DEL_ACTION = "del";

    public static final String FIND_ALL_ACTION = "findAll";

    @Autowired
    private RedisRouteDefinitionRepository routeDefinitionRepository;

    @EventListener(value = { GatewayRouteEvent.class })
    public void actionReceive() {
        routeDefinitionRepository.getRouteDefinitions();
    }


}
