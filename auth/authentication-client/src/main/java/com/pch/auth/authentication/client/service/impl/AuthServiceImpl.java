package com.pch.auth.authentication.client.service.impl;

import com.pch.auth.authentication.client.provide.AuthenticationProvide;
import com.pch.auth.authentication.client.service.AuthService;
import com.pch.common.response.CommonResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @Author: pch
 * @Date: 2021/4/22 10:11
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    public static final String BEARER = "Bearer ";

    @Value("${spring.security.oauth2.jwt.signingKey}")
    public String signingKey;

    @Autowired
    private AuthenticationProvide authenticationProvide;

    @Override
    public Boolean authentication(String authorization, String url, HttpMethod method) {
        log.info("开始调用调用认证服务authentication-service, 调用token：{}， 调用url：{}， 调用方法：{}", authorization, url, method);
        if (StringUtils.isBlank(authorization) || !authorization.startsWith(BEARER)) {
            log.error("token is null or prefix error");
            return Boolean.FALSE;
        }
        if (invalidJwtAccessToken(authorization)) {
            return Boolean.FALSE;
        }
        CommonResult<Boolean> result = authenticationProvide.authentication(authorization, url, method);
        log.info("调用调用认证服务结束,返回值为：{}", result);
        return StringUtils.equalsIgnoreCase(result.getCode(), CommonResult.SUCCESS_CODE) && result.getData();
    }

    /**
     * token是否无效  true 无效
     *
     * @param authorization token凭证
     */
    public Boolean invalidJwtAccessToken(String authorization) {
        Boolean flag = Boolean.TRUE;
        try {
            getJwtToken(authorization);
            flag = Boolean.FALSE;
        } catch (Exception e) {
            log.error("parse token error", e);
        }
        return flag;
    }


    public Jws<Claims> getJwtToken(String jwtToken) {
        if (jwtToken.startsWith(BEARER)) {
            jwtToken = StringUtils.substring(jwtToken, BEARER.length());
        }
        return Jwts.parser().setSigningKey(signingKey.getBytes()).parseClaimsJws(jwtToken);

    }

    @Override
    public Boolean ignoreUrls(String matchUrl) {
        return Stream.of("/oauth/token", "/v2/api-docs").anyMatch(url -> matchUrl.endsWith(StringUtils.trim(url)));
    }

}
