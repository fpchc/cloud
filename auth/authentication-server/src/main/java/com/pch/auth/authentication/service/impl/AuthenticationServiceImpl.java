package com.pch.auth.authentication.service.impl;

import com.pch.auth.authentication.service.AuthenticationService;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @Author: pch
 * @Date: 2021/5/6 16:20
 */
@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public Boolean authentication(HttpServletRequest request) {
        log.info("请求url：{}， 请求方法：{}", request.getRequestURL(), request.getMethod());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();

        return Boolean.TRUE;
    }

}
