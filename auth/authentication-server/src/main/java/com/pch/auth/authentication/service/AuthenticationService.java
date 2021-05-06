package com.pch.auth.authentication.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: pch
 * @Date: 2021/5/6 16:20
 */
public interface AuthenticationService {

    /**
     * 认证 token 是否具备访问权限.
     *
     * @param request HttpServletRequest
     */
    Boolean authentication(HttpServletRequest request);

}
