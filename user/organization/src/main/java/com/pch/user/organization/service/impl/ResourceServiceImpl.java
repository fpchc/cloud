package com.pch.user.organization.service.impl;

import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.model.po.ResourcePo;
import com.pch.user.organization.model.po.RoleResourcePo;
import com.pch.user.organization.model.po.UserRolePo;
import com.pch.user.organization.repository.ResourceRepository;
import com.pch.user.organization.repository.RoleResourceRepository;
import com.pch.user.organization.repository.UserRoleRepository;
import com.pch.user.organization.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleResourceRepository roleResourceRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
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
    @Transactional
    public Long add(ResourcesDto resourcesDto) {
        ResourcePo resourcePo = new ResourcePo();
        BeanUtils.copyProperties(resourcesDto, resourcePo);
        resourcePo = resourceRepository.save(resourcePo);
        return resourcePo.getId();
    }

    @Override
    public ResourcesDto findById(Long id) {
        Optional<ResourcePo> permissionPo = resourceRepository.findById(id);
        ResourcesDto resourcesDto = new ResourcesDto();
        permissionPo.ifPresent(resourcePo1 -> BeanUtils.copyProperties(resourcePo1, resourcesDto));
        return resourcesDto;
    }
}
