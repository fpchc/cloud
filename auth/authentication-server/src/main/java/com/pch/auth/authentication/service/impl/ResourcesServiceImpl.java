package com.pch.auth.authentication.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.provide.ResourceProvide;
import com.pch.auth.authentication.service.NewMvcRequestMatch;
import com.pch.auth.authentication.service.ResourcesService;
import com.pch.common.exception.ServiceException;
import com.pch.common.response.CommonResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourcesServiceImpl implements ResourcesService {

    private final HandlerMappingIntrospector introspector;

    private final ResourceProvide resourceProvide;

    private static final Map<RequestMatcher, ConfigAttribute> resourceDtoCache = new ConcurrentHashMap<>();

    @Override
    @Cached(name = "resource:username:", key = "#username", cacheType = CacheType.REMOTE)
    public List<ResourceDto> findByUsername(String username) {
        CommonResult<List<ResourceDto>> result = resourceProvide.findByUsername(username);
        if (StringUtils.equalsIgnoreCase(CommonResult.SUCCESS_CODE, result.getCode())) {
            return result.getData();
        }
        return new ArrayList<>();
    }

    @Override
    public ConfigAttribute findConfigAttributeByUrl(HttpServletRequest request) {
       return resourceDtoCache.keySet().stream()
                .filter(requestMatcher -> requestMatcher.matches(request))
                .map(resourceDtoCache::get)
                .peek(configAttribute -> log.info("url在资源池中配置：{}", configAttribute.getAttribute()))
                .findFirst().orElse(new SecurityConfig("NONEXISTENT_URL"));
    }

    @Override
    @PostConstruct
    public Boolean loadCacheResources() {
        CommonResult<List<ResourceDto>> result = resourceProvide.findAll();
        if (!StringUtils.equalsIgnoreCase(result.getCode(), CommonResult.SUCCESS_CODE)) {
            throw new ServiceException("5000001", "加载资源信息错误！");
        }
        for (ResourceDto resourceDto : result.getData()) {
            resourceDtoCache.put(
                    newMvcRequestMatch(resourceDto.getUrl(), resourceDto.getMethod()),
                    new SecurityConfig(resourceDto.getCode())
            );
        }
        return Boolean.TRUE;
    }

    private NewMvcRequestMatch newMvcRequestMatch(String url, String method) {
        return new NewMvcRequestMatch(introspector, url, method);
    }

}
