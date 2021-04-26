package com.pch.auth.authentication.service.impl;

import com.pch.auth.authentication.model.dto.PermissionDto;
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
    private RoleResourcesRepository roleResourcesRepository;

    @Autowired
    private ResourcesRepository resourcesRepository;

    @Override
    public List<ResourcesPo> findByUserId(Long userId) {
        List<UserRolePo> userRolePos = userRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(userRolePos)) {
            return null;
        }
        List<Long> roleIds = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
        List<RoleResourcesPo> roleResourcesPos = roleResourcesRepository.findByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(roleResourcesPos)) {
            return null;
        }
        List<Long> permissionIds = roleResourcesPos.stream().map(RoleResourcesPo::getResourcesId)
                .collect(Collectors.toList());
        return resourcesRepository.findByResourcesIds(permissionIds);
    }

    @Override
    @Transactional
    public Long add(PermissionDto permissionDto) {
        ResourcesPo resourcesPo = new ResourcesPo();
        BeanUtils.copyProperties(permissionDto, resourcesPo);
        resourcesPo = resourcesRepository.save(resourcesPo);
        return resourcesPo.getId();
    }

    @Override
    public PermissionDto findById(Long id) {
        Optional<ResourcesPo> permissionPo = resourcesRepository.findById(id);
        PermissionDto permissionDto = new PermissionDto();
        permissionPo.ifPresent(resourcesPo1 -> BeanUtils.copyProperties(resourcesPo1, permissionDto));
        return permissionDto;
    }
}
