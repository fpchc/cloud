package com.pch.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author: pch
 * @Date: 2021/5/27 15:27
 */
@SuppressWarnings("unchecked")
public class UserInfoInterceptor implements HandlerInterceptor {

    public static final String CLIENT_TOKEN_USER = "clientUser";

    @Override
    public boolean preHandle(HttpServletRequest request, @Nullable HttpServletResponse response,
            @Nullable Object handler) throws Exception {
        //todo checked token
        String userInfo = StringUtils.defaultIfBlank(request.getHeader(CLIENT_TOKEN_USER), "{}");
        UserContextHolder.getInstants().setContexts(new ObjectMapper().readValue(userInfo, Map.class));
        return true;
    }

    @Override
    public void afterCompletion(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response,
            @Nullable Object handler, Exception ex) throws Exception {
        UserContextHolder.getInstants().clean();
    }
}
