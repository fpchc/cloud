package com.pch.user.organization.service;

import com.pch.user.organization.model.dto.PermissionDto;
import com.pch.user.organization.model.po.PermissionPo;
import java.util.List;

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
