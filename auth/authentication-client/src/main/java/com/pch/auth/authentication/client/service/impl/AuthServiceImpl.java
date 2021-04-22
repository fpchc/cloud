package com.pch.auth.authentication.client.service.impl;

import com.pch.auth.authentication.client.provide.AuthenticationProvide;
import com.pch.auth.authentication.client.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String test() {
        return authenticationProvide.getString().getData();
    }
}
