package com.pch.gateway.rest;

import com.pch.auth.authentication.client.service.AuthService;
import com.pch.gateway.model.dto.GatewayRouteDto;
import com.pch.gateway.service.GatewayRouteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <P>路由管理 给admin使用</P>
 *
 * @Author: pch
 * @Date: 2020-12-12 11:50
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/gateway/route")
public class GatewayRouteController {

    private final GatewayRouteService gatewayRouteService;

    private final AuthService authService;

    @PostMapping("/add")
    public Mono<Boolean> add(@Validated @RequestBody List<GatewayRouteDto> gatewayRouteDtoList) {
        return Mono.just(gatewayRouteService.saveOrUpdate(gatewayRouteDtoList));
    }

    @PostMapping("/overload")
    public Mono<Boolean> overload() {
        return Mono.just(gatewayRouteService.overload());
    }

    @GetMapping("/findAll")
    public Flux<GatewayRouteDto> findAll() {
        return Flux.fromIterable(gatewayRouteService.findAll());
    }

    @DeleteMapping("/del/{id}")
    public Mono<Boolean> del(@PathVariable String id) {
        return Mono.just(gatewayRouteService.delete(id));
    }

    @PostMapping("/test")
    public Mono<String> get() {
        return Mono.just(authService.test());
    }

}
