package com.pch.gateway.rest;

import javax.validation.Valid;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pch.common.exception.ServiceException;
import com.pch.common.response.CommonResult;
import com.pch.gateway.event.UserEvent;
import com.pch.gateway.model.domain.UserPo;
import com.pch.gateway.router.RedisRouteDefinitionRepository;
import com.pch.gateway.service.UserService;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping(value = "/gateway", consumes = MediaType.APPLICATION_JSON_VALUE)
public class RouteController {

    private final ApplicationContext applicationContext;

    private final UserService userService;

    private final RedisRouteDefinitionRepository routeDefinitionRepository;

    @PostMapping("/route")
    public Mono<Boolean> addRoutes(@Valid @RequestBody RouteDefinition routeDefinition) {
        Mono<Void> save = routeDefinitionRepository.save(Mono.just(routeDefinition));
        return Mono.just(true);
    }

    @DeleteMapping("/route/{id}")
    public Mono<Boolean> delRoutes(@PathVariable String routeId) {
        Mono<Void> delete = routeDefinitionRepository.delete(Mono.just(routeId));
        return Mono.just(true);
    }

    @PostMapping(value = "/userEvent")
    public CommonResult<Boolean> userEvent(@RequestBody UserPo userPo) {
        log.info("当前线程名称：{}", Thread.currentThread().getName());
        applicationContext.publishEvent(new UserEvent("insert", userPo));
        return CommonResult.success();
    }

    @GetMapping(value = "/users")
    public CommonResult<IPage<UserPo>> users(Page<UserPo> page) {
        if (true) throw new ServiceException(1111L, "测试使用");
        return CommonResult.success(userService.page(page));
    }

}
