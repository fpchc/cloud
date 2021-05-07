package com.pch.user.organization.service.impl;

import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.model.po.ResourcePo;
import com.pch.user.organization.model.po.RoleResourcePo;
import com.pch.user.organization.model.po.UserRolePo;
import com.pch.user.organization.repository.ResourceRepository;
import com.pch.user.organization.repository.RoleResourceRepository;
import com.pch.user.organization.repository.UserRoleRepository;
import com.pch.user.organization.service.ResourceService;
import com.pch.user.organization.service.mapstruct.ResourceMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final UserRoleRepository userRoleRepository;

    private final RoleResourceRepository roleResourceRepository;

    private final ResourceRepository resourceRepository;

    private final ResourceMapper resourceMapper;

    public static final String RESOURCE_PREFIX = "resource:";

    @Override
    @Transactional(readOnly = true)
    public List<ResourcePo> findByUserId(Long userId) {
        List<UserRolePo> userRolePos = userRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(userRolePos)) {
            return null;
        }
        List<Long> roleIds = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
        List<RoleResourcePo> roleResourcePos = roleResourceRepository.findByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(roleResourcePos)) {
            return null;
        }
        List<Long> permissionIds = roleResourcePos.stream().map(RoleResourcePo::getPermissionId)
                .collect(Collectors.toList());
        return resourceRepository.findByPermissionIds(permissionIds);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResourcesDto> findAll() {
        List<ResourcePo> resourcePosFromDateBase = resourceRepository.findAll();
        return resourcePosFromDateBase.stream().map(resourceMapper::poToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Long add(ResourcesDto resourcesDto) {
        ResourcePo resourcePo = resourceMapper.dtoToPo(resourcesDto);
        return resourcePo.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public ResourcesDto findById(Long id) {
        Optional<ResourcePo> permissionPo = resourceRepository.findById(id);
        return permissionPo.map(resourceMapper::poToDto).orElse(null);
    }
}
