package com.pch.auth.service;

import java.util.List;

import com.pch.auth.domain.PermissionPo;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface PermissionService {

    /**
     * 获取关联用户权限
     *
     * @param userId    用户id
     * @return
     */
    List<PermissionPo> findByUserId(Long userId);
}
