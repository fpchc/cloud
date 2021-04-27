package com.pch.auth.authentication.service.impl;

import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.model.po.ResourcesPo;
import com.pch.auth.authentication.model.po.RoleResourcesPo;
import com.pch.auth.authentication.model.po.UserRolePo;
import com.pch.auth.authentication.repository.ResourcesRepository;
import com.pch.auth.authentication.repository.RoleResourcesRepository;
import com.pch.auth.authentication.repository.UserRoleRepository;
import com.pch.auth.authentication.service.ResourcesService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourcesServiceImpl implements ResourcesService {

    private final UserRoleRepository userRoleRepository;

    private final RoleResourcesRepository roleResourcesRepository;

    private final ResourcesRepository resourcesRepository;

    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String signingKey;

    @Override
    public List<ResourcesPo> findByUserId(Long userId) {
        List<UserRolePo> userRolePos = userRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(userRolePos)) {
            log.info("该用户没有绑定角色！！");
            return null;
        }
        List<Long> roleIds = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
        List<RoleResourcesPo> roleResourcesPos = roleResourcesRepository.findByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(roleResourcesPos)) {
            log.info("该用户没有绑定资源权限！！");
            return null;
        }
        List<Long> permissionIds = roleResourcesPos.stream().map(RoleResourcesPo::getResourcesId)
                .collect(Collectors.toList());
        return resourcesRepository.findByResourcesIds(permissionIds);
    }

    @Override
    @Transactional
    public Long add(ResourceDto resourceDto) {
        ResourcesPo resourcesPo = new ResourcesPo();
        BeanUtils.copyProperties(resourceDto, resourcesPo);
        resourcesPo = resourcesRepository.save(resourcesPo);
        return resourcesPo.getId();
    }

    @Override
    public Boolean authentication(HttpServletRequest request, String url, String method) {
        log.info("请求url：{}， 请求方法：{}", url, method);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null;
    }

    @Override
    public ResourceDto findById(Long id) {
        Optional<ResourcesPo> permissionPo = resourcesRepository.findById(id);
        ResourceDto resourceDto = new ResourceDto();
        permissionPo.ifPresent(resourcesPo1 -> BeanUtils.copyProperties(resourcesPo1, resourceDto));
        return resourceDto;
    }
}
