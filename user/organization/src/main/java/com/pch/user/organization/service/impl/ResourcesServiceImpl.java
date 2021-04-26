package com.pch.user.organization.service.impl;

import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.model.po.ResourcesPo;
import com.pch.user.organization.model.po.RoleResourcesPo;
import com.pch.user.organization.model.po.UserRolePo;
import com.pch.user.organization.repository.PermissionRepository;
import com.pch.user.organization.repository.RolePermissionRepository;
import com.pch.user.organization.repository.UserRoleRepository;
import com.pch.user.organization.service.ResourcesService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<ResourcesPo> findByUserId(Long userId) {
        List<UserRolePo> userRolePos = userRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(userRolePos)) {
            return null;
        }
        List<Long> roleIds = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
        List<RoleResourcesPo> roleResourcesPos = rolePermissionRepository.findByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(roleResourcesPos)) {
            return null;
        }
        List<Long> permissionIds = roleResourcesPos.stream().map(RoleResourcesPo::getPermissionId)
                .collect(Collectors.toList());
        return permissionRepository.findByPermissionIds(permissionIds);
    }

    @Override
    @Transactional
    public Long add(ResourcesDto resourcesDto) {
        ResourcesPo resourcesPo = new ResourcesPo();
        BeanUtils.copyProperties(resourcesDto, resourcesPo);
        resourcesPo = permissionRepository.save(resourcesPo);
        return resourcesPo.getId();
    }

    @Override
    public ResourcesDto findById(Long id) {
        Optional<ResourcesPo> permissionPo = permissionRepository.findById(id);
        ResourcesDto resourcesDto = new ResourcesDto();
        permissionPo.ifPresent(resourcesPo1 -> BeanUtils.copyProperties(resourcesPo1, resourcesDto));
        return resourcesDto;
    }
}
