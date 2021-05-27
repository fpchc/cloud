package com.pch.common.config;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: pch
 * @Date: 2021/5/27 15:30
 */
public class UserContextHolder {

    private static ThreadLocal<Map<String, String>> threadLocal;

    private UserContextHolder() {
        threadLocal = new ThreadLocal<>();
    }

    public static UserContextHolder getInstants() {
        return SingletonHolder.instants;
    }

    private static class SingletonHolder {
        private static UserContextHolder instants = new UserContextHolder();
    }

    /**
     * 获取上下文
     */
    public void setContexts(Map<String, String> map) {
        threadLocal.set(map);
    }

    public Map<String, String> get() {
        return threadLocal.get();
    }

    public static String getUsername() {
        return Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get(UserInfoInterceptor.CLIENT_TOKEN_USER);
    }

    public void clean() {
        threadLocal.remove();
    }



}
