package com.pch.auth.authorization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.auth.authorization.model.dto.RoleDto;
import com.pch.auth.authorization.model.po.RolePo;
import java.util.List;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleService extends IService<RolePo> {

    /**
     * 通过userId查询角色集合
     *
     * @param userId    用户id
     */
    List<RoleDto> findByUserId(Long userId);

}
