package com.pch.auth.authentication.client.service.impl;

import com.pch.auth.authentication.client.provide.AuthenticationProvide;
import com.pch.auth.authentication.client.service.AuthService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @Author: pch
 * @Date: 2021/4/22 10:11
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationProvide authenticationProvide;

    @Override
    public boolean authentication(String authorization, String url, HttpMethod method) {
        return authenticationProvide.authentication(authorization, url, method);
    }

    @Override
    public String test(String authorization) {
        return authenticationProvide.getString(authorization).getData();
    }

    @Override
    public List<String> ignoreUrls() {
        return Stream.of("/oauth").collect(Collectors.toList());
    }
}
