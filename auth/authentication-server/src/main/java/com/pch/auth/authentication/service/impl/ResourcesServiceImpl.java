package com.pch.auth.authentication.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.provide.ResourceProvide;
import com.pch.auth.authentication.service.NewMvcRequestMatch;
import com.pch.auth.authentication.service.ResourcesService;
import com.pch.common.response.CommonResult;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
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

    public static final String RESOURCE_CACHE_PREFIX = "resource:";

    private final HandlerMappingIntrospector introspector;

    private final ResourceProvide resourceProvide;

    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String signingKey;

    @CreateCache(name = RESOURCE_CACHE_PREFIX, cacheType = CacheType.REMOTE,
            expire = CacheConsts.DEFAULT_EXPIRE, timeUnit = TimeUnit.HOURS)
    private Cache<RequestMatcher, ConfigAttribute> resourceDtoCache;


    @Override
    @PostConstruct
    @Transactional(readOnly = true)
    public Boolean loadCacheResources() {
        CommonResult<List<ResourceDto>> result = resourceProvide.findAll();
        if (!StringUtils.equalsIgnoreCase(result.getCode(), CommonResult.SUCCESS_CODE)) {
            System.exit(1);
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
