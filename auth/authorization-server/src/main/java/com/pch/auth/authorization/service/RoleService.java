package com.pch.auth.authorization.service;

import com.pch.auth.authorization.model.dto.RoleDto;
import java.util.List;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleService {

    /**
     * 通过userId查询角色集合
     *
     * @param userId    用户id
     */
    List<RoleDto> findByUserId(Long userId);

}
