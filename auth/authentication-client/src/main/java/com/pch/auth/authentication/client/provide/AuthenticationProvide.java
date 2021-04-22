package com.pch.auth.authentication.client.provide;

import com.pch.common.response.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: pch
 * @Date: 2021/4/19 17:23
 */
@Component
@FeignClient(name = "authentication-service")
public interface AuthenticationProvide {

    @GetMapping("/authentication/get")
    CommonResult<String> getString();

}
