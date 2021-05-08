package com.pch.auth.authentication.service;

import com.pch.auth.authentication.model.dto.ResourceDto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.access.ConfigAttribute;

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

    /**
     * 通过请求获取url
     *
     * @param request   request
     */
    ConfigAttribute findConfigAttributeByUrl(HttpServletRequest request);

    /**
     * 通过username查询资源
     *
     * @param username
     */
    List<ResourceDto> findByUsername(String username);
}
