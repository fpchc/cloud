package com.pch.auth.authentication.service.impl;

import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.repository.ResourcesRepository;
import com.pch.auth.authentication.repository.RoleResourcesRepository;
import com.pch.auth.authentication.repository.UserRoleRepository;
import com.pch.auth.authentication.service.ResourcesService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

    @CreateCache(name = RESOURCE_CACHE_PREFIX, cacheType = CacheType.REMOTE)
    private List<ResourceDto> resourceDtoList;

    @Override
    public Boolean authentication(HttpServletRequest request, String url, String method) {
        log.info("请求url：{}， 请求方法：{}", url, method);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null;
    }

}
