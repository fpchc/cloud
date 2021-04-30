package com.pch.auth.authentication.client.service;

import org.springframework.http.HttpMethod;

/**
 * @Author: pch
 * @Date: 2021/4/22 10:10
 */
public interface AuthService {

    String test(String authorization);

    /**
     * 获取需要忽略的url
     *
     * @param matchUrl 需要匹配的url
     * @return true: match success
     */
    Boolean ignoreUrls(String matchUrl);


    boolean authentication(String authorization, String url, HttpMethod method);
}
