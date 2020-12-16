package com.pch.gateway.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.response.CommonResult;

/**
 * <P>路由管理 给admin使用</P>
 *
 * @Author: pch
 * @Date: 2020-12-12 11:50
 */
@RestController
@RequestMapping(value = "/gateway", consumes = MediaType.APPLICATION_JSON_VALUE)
public class RouteController {

    @PostMapping("/route")
    public CommonResult<Boolean> addRoutes() {
        return CommonResult.success();
    }

}
