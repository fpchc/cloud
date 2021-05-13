package com.pch.auth.authentication.service.impl;

import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.service.AuthenticationService;
import com.pch.auth.authentication.service.ResourcesService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @Author: pch
 * @Date: 2021/5/6 16:20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final ResourcesService resourcesService;

    /**
     * 未在资源库中的URL默认标识
     */
    public static final String NONEXISTENT_URL = "NONEXISTENT_URL";

    @Override
    public Boolean authentication(HttpServletRequest request) {
        log.info("请求url：{}， 请求方法：{}", request.getRequestURL(), request.getMethod());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ConfigAttribute configAttribute = resourcesService.findConfigAttributeByUrl(request);
        if (StringUtils.equalsIgnoreCase(NONEXISTENT_URL, configAttribute.getAttribute())) {
            log.warn("请求url在资源中没有找到");
        }
        List<ResourceDto> resourceDtoList = resourcesService.findByUsername(authentication.getName());
        return isMatch(configAttribute, resourceDtoList);
    }

    /**
     * 资源code匹配
     *
     * @param configAttribute   请求code
     * @param resourceDtoList   用户资源code
     * @return 匹配成功返回true
     */
    private Boolean isMatch(ConfigAttribute configAttribute, List<ResourceDto> resourceDtoList) {
        return resourceDtoList.stream().anyMatch(resourceDto -> configAttribute.getAttribute().matches(resourceDto.getCode()));
    }

}
