package com.pch.auth.authentication.client.provide;

import com.pch.common.response.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: pch
 * @Date: 2021/4/19 17:23
 */
@Component
@FeignClient(name = "authentication-service", fallback = AuthenticationProvideBack.class)
public interface AuthenticationProvide {

    @PostMapping("/authentication/resource/authentication")
    CommonResult<Boolean> authentication(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
            @RequestParam("url") String url, @RequestParam("method") HttpMethod method);
}
