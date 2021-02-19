package com.pch.gateway.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.gateway.model.dto.GatewayRouteDto;
import com.pch.gateway.service.GatewayRouteService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * <P>路由管理 给admin使用</P>
 *
 * @Author: pch
 * @Date: 2020-12-12 11:50
 */
@Slf4j
@RestController
@RequestMapping(value = "/gateway/route")
public class GatewayRouteController {

    @Autowired
    private GatewayRouteService gatewayRouteService;

    @PostMapping("/add")
    public Mono<Boolean> add(@Valid @RequestBody GatewayRouteDto gatewayRouteDto) {
        return Mono.just(gatewayRouteService.add(gatewayRouteDto));
    }

}
