package com.pch.user.organization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.user.organization.dao.RoleDao;
import com.pch.user.organization.model.dto.RoleDto;
import com.pch.user.organization.model.po.RolePo;
import com.pch.user.organization.service.RoleService;
import com.pch.user.organization.service.mapstruct.RoleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: admin
 * @Date: 2021/2/24
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleDao, RolePo> implements RoleService {

    private final RoleMapper roleMapper;

    @Override
    public RoleDto findById(Long id) {
        return roleMapper.sourceToTarget(this.baseMapper.selectById(id));
    }

    @Override
    public Page<RoleDto> query(RoleDto roleDto) {
        return null;
    }

    @Override
    @Transactional
    public Boolean save(RoleDto roleDto) {
        return this.saveOrUpdate(roleMapper.targetToSource(roleDto));
    }
}
