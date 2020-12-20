package com.pch.gateway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.response.CommonResult;
import com.pch.gateway.event.UserEvent;
import com.pch.gateway.model.domain.UserPo;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>路由管理 给admin使用</P>
 *
 * @Author: pch
 * @Date: 2020-12-12 11:50
 */
@Slf4j
@RestController
@RequestMapping(value = "/gateway", consumes = MediaType.APPLICATION_JSON_VALUE)
public class RouteController {

    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping("/route")
    public CommonResult<Boolean> addRoutes() {
        return CommonResult.success();
    }

    @GetMapping(value = "/userEvent")
    public CommonResult<Boolean> userEvent (@RequestBody UserPo userPo) {
        log.info("当前线程名称：{}", Thread.currentThread().getName());
        applicationContext.publishEvent(new UserEvent("", userPo, "insert"));
        return CommonResult.success();
    }

}
