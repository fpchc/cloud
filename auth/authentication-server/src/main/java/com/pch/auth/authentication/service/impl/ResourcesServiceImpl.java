package com.pch.auth.authentication.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.model.po.ResourcePo;
import com.pch.auth.authentication.repository.ResourceRepository;
import com.pch.auth.authentication.service.ResourcesService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourcesServiceImpl implements ResourcesService {

    public static final String RESOURCE_CACHE_PREFIX = "resource:";

    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String signingKey;

    @CreateCache(name = RESOURCE_CACHE_PREFIX, cacheType = CacheType.REMOTE, expire = CacheConsts.DEFAULT_EXPIRE)
    private Cache<String, ResourceDto> resourceDtoCache;

    private final ResourceRepository resourceRepository;

    @Override
    public Boolean authentication(HttpServletRequest request) {
        log.info("请求url：{}， 请求方法：{}", request.getRequestURL(), request.getMethod());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        return Boolean.TRUE;
    }

    @Override
    @PostConstruct
    @Transactional(readOnly = true)
    public Boolean loadCacheResources() {
        try {
            List<ResourcePo> resourcePoList = resourceRepository.findAll();
            for (ResourcePo resourcePo : resourcePoList) {
                ResourceDto resourceDto = new ResourceDto();
                BeanUtils.copyProperties(resourcePo, resourceDto);
                resourceDtoCache.PUT(resourceDto.getCode(), resourceDto);
            }
        } catch (Exception e) {
            log.error("资源存入redis失败", e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
