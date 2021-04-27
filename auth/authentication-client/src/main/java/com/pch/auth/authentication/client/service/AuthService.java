package com.pch.auth.authentication.client.service;

import java.util.List;
import org.springframework.http.HttpMethod;

/**
 * @Author: pch
 * @Date: 2021/4/22 10:10
 */
public interface AuthService {

    String test(String authorization);

    /**
     * 获取需要忽略的url
     */
    List<String> ignoreUrls();


    boolean authentication(String authorization, String url, HttpMethod method);
}
