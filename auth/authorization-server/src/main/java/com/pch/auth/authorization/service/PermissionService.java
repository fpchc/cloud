package com.pch.auth.authorization.service;

import java.util.List;

import com.pch.auth.authorization.model.domain.PermissionPo;
import com.pch.auth.authorization.model.dto.PermissionDto;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface PermissionService {

    /**
     * 获取关联用户权限
     *
     * @param userId 用户id
     * @return
     */
    List<PermissionPo> findByUserId(Long userId);

    PermissionDto findById(Long id);

    Long add(PermissionDto permissionDto);
}
