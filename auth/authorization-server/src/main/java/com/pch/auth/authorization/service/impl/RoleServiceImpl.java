package com.pch.auth.authorization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.auth.authorization.dao.RoleDao;
import com.pch.auth.authorization.model.dto.RoleDto;
import com.pch.auth.authorization.model.po.RolePo;
import com.pch.auth.authorization.service.RoleService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleDao, RolePo> implements RoleService {

    private final RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<RoleDto> findByUserId(Long userId) {
        List<RolePo> rolePoList = roleDao.findByUserId(userId);
        return rolePoList.stream().map(rolePo -> {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(rolePo, roleDto);
            return roleDto;
        }).collect(Collectors.toList());
    }
}
