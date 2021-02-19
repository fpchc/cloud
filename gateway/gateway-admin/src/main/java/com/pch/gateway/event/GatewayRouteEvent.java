package com.pch.gateway.event;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2020-12-19 20:38
 */
public class GatewayRouteEvent extends ApplicationEvent {

    private static final long serialVersionUID = -5707310134577625463L;

    public static final String GATEWAY_ROUTES = "gateway_routes:";

    @Getter
    @Setter
    private RouteDefinition routeDefinition;

    public GatewayRouteEvent(Object source, RouteDefinition routeDefinition) {
        super(source);
        this.routeDefinition = routeDefinition;
    }
}
