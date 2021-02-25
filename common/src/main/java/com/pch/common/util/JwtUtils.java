package com.pch.common.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * <p> jwt 生成token 验证token工具类 </p>
 *
 * @Author: pch
 * @Date: 2020/12/25 14:21
 */
public class JwtUtils {

    private static final String BEARER = "Bearer ";

    @Value("spring.security.oauth2.jwt.signingKey")
    private String secret;





}
