package com.pch.auth.authentication.client.provide;

import com.pch.common.response.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @Author: pch
 * @Date: 2021/4/19 17:23
 */
@Component
@FeignClient(name = "authentication-service")
public interface AuthenticationProvide {

    @GetMapping("/authentication/get")
    CommonResult<String> getString(@RequestHeader(HttpHeaders.AUTHORIZATION) String authentication);

}
