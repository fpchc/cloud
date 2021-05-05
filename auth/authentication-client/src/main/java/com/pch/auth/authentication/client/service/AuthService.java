package com.pch.auth.authentication.client.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.http.HttpMethod;

/**
 * @Author: pch
 * @Date: 2021/4/22 10:10
 */
public interface AuthService {

    /**
     * 获取需要忽略的url
     *
     * @param matchUrl 需要匹配的url
     * @return true: match success
     */
    Boolean ignoreUrls(String matchUrl);

    /**
     * token是否无效  true 无效
     *
     * @param authorization token凭证
     */
    Boolean invalidJwtAccessToken(String authorization);

    /**
     * 解析token
     *
     * @param jwtToken token密匙
     */
    Jws<Claims> getJwtToken(String jwtToken);

    /**
     * 权限鉴定
     *
     * @param authorization 授权码
     * @param url           请求url
     * @param method        请求方法
     */
    Boolean authentication(String authorization, String url, HttpMethod method);
}
