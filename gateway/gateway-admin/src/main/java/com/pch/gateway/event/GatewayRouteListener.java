package com.pch.gateway.event;

import com.pch.gateway.router.RedisRouteDefinitionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: pch
 * @Date: 2020-12-20 13:31
 */
@Slf4j
@Async
@Component
@RequiredArgsConstructor
public class GatewayRouteListener {

    public static final String SAVE_ACTION = "save";

    public static final String DEL_ACTION = "del";

    public static final String FIND_ALL_ACTION = "findAll";

    private final RedisRouteDefinitionRepository routeDefinitionRepository;

    @EventListener(value = { GatewayRouteEvent.class },
            condition = "#gatewayRouteEvent.getSource().toString() eq "
                    + "(T(com.pch.gateway.event.GatewayRouteListener).FIND_ALL_ACTION)")
    public void actionReceive(GatewayRouteEvent gatewayRouteEvent) {
        log.info("路由监听器执行===>{}", gatewayRouteEvent);
        routeDefinitionRepository.getRouteDefinitions();
    }


}
