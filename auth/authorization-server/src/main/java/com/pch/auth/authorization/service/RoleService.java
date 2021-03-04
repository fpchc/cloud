package com.pch.auth.authorization.service;

import com.pch.auth.authorization.model.dto.RoleDto;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleService {

    /**
     * 通过id查询角色
     *
     * @param id
     * @return
     */
    RoleDto findById(Long id);

    Long save(RoleDto roleDto);
}
