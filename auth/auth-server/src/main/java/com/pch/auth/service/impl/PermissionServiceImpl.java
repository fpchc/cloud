package com.pch.auth.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.pch.auth.model.domain.PermissionPo;
import com.pch.auth.model.domain.RolePermissionPo;
import com.pch.auth.model.domain.UserRolePo;
import com.pch.auth.model.dto.PermissionDto;
import com.pch.auth.repository.PermissionRepository;
import com.pch.auth.repository.RolePermissionRepository;
import com.pch.auth.repository.UserRoleRepository;
import com.pch.auth.service.PermissionService;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<PermissionPo> findByUserId(Long userId) {
        List<UserRolePo> userRolePos = userRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(userRolePos)) {
            return null;
        }
        List<Long> roleIds = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
        List<RolePermissionPo> rolePermissionPos = rolePermissionRepository.findByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(rolePermissionPos)) {
            return null;
        }
        List<Long> permissionIds = rolePermissionPos.stream().map(RolePermissionPo::getPermissionId).collect(Collectors.toList());
        return permissionRepository.findByPermissionIds(permissionIds);
    }

    @Override
    @Transactional
    public Long add(PermissionDto permissionDto) {
        PermissionPo permissionPo = new PermissionPo();
        BeanUtils.copyProperties(permissionDto, permissionPo);
        permissionPo = permissionRepository.save(permissionPo);
        return permissionPo.getId();
    }

    @Override
    public PermissionDto findById(Long id) {
        Optional<PermissionPo> permissionPo = permissionRepository.findById(id);
        PermissionDto permissionDto = new PermissionDto();
        permissionPo.ifPresent(permissionPo1 -> BeanUtils.copyProperties(permissionPo1, permissionDto));
        return permissionDto;
    }
}
