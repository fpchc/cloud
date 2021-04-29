package com.pch.auth.authentication.client.service.impl;

import com.pch.auth.authentication.client.provide.AuthenticationProvide;
import com.pch.auth.authentication.client.service.AuthService;
import com.pch.common.response.CommonResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.util.List;
import java.util.stream.Collectors;
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

    public static final String BROKEN = "Broken ";

    @Value("${spring.security.oauth2.jwt.signingKey}")
    public String signingKey;

    @Autowired
    private AuthenticationProvide authenticationProvide;

    @Override
    public boolean authentication(String authorization, String url, HttpMethod method) {
        if (StringUtils.isNotBlank(authorization) && authorization.startsWith(BROKEN)) {
            log.error("token is null or prefix error");
            return Boolean.FALSE;
        }
        if (invalidJwtAccessToken(authorization)) {
            return Boolean.FALSE;
        }
        return authenticationProvide.authentication(authorization, url, method).getData();
    }

    /**
     * token是否无效  true 无效
     *
     * @param authorization token凭证
     */
    private boolean invalidJwtAccessToken(String authorization) {
        Boolean flag = Boolean.TRUE;
        try {
            getJwtToken(authorization);
            flag = Boolean.FALSE;
        } catch (Exception e) {
            log.error("parse token error: {}", authorization);
        }
        return flag;
    }

    /**
     * 解析token
     *
     * @param jwtToken  token密匙
     */
    private Jws<Claims> getJwtToken(String jwtToken) {
        if (jwtToken.startsWith(BROKEN)) {
            jwtToken = StringUtils.substring(jwtToken, BROKEN.length());
        }
        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwtToken);

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
