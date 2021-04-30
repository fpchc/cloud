package com.pch.auth.authorization.service.impl;

import com.pch.auth.authorization.exceaption.RoleNotFoundException;
import com.pch.auth.authorization.model.dto.RoleDto;
import com.pch.auth.authorization.model.po.RolePo;
import com.pch.auth.authorization.model.po.UserRolePo;
import com.pch.auth.authorization.repository.RoleRepository;
import com.pch.auth.authorization.repository.UserRoleRepository;
import com.pch.auth.authorization.service.RoleService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RoleDto> findByUserId(Long userId) {
        List<UserRolePo> userRolePoList = userRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(userRolePoList)) {
            throw new RoleNotFoundException("this user is not bound roles");
        }
        List<Long> roleIdList = userRolePoList.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
        List<RolePo> rolePoList = roleRepository.findAllById(roleIdList);
        return rolePoList.stream().map(rolePo -> {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(rolePo, roleDto);
            return roleDto;
        }).collect(Collectors.toList());
    }
}
