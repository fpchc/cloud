package com.pch.auth.authentication.client.provide;

import com.pch.common.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;

/**
 * @Author: pch
 * @Date: 2021/4/29 16:34
 */
@Slf4j
public class AuthenticationProvideBack implements AuthenticationProvide{

    @Override
    public CommonResult<String> getString(String authentication) {
        log.error("认证服务没有启动");
        return CommonResult.failed();
    }

    @Override
    public CommonResult<Boolean> authentication(String authorization, String url, HttpMethod method) {
        log.error("认证服务没有启动");
        return CommonResult.failed();
    }
}
