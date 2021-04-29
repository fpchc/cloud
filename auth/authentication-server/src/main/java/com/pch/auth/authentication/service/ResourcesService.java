package com.pch.auth.authentication.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface ResourcesService {

    /**
     * 认证 token 是否具备访问权限.
     *
     * @param request HttpServletRequest
     * @param url     请求url
     * @param method  请求方法
     */
    Boolean authentication(HttpServletRequest request, String url, String method);
}
