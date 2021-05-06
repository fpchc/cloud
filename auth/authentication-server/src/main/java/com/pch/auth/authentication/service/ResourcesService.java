package com.pch.auth.authentication.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface ResourcesService {


    /**
     * 加载所有资源到redis服务器
     *
     * @return  成功返回true
     */
    Boolean loadCacheResources();
}
