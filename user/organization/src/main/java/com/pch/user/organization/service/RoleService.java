package com.pch.user.organization.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.user.organization.model.dto.RoleDto;
import com.pch.user.organization.model.po.ResourcePo;
import com.pch.user.organization.model.po.RolePo;
import org.springframework.data.domain.Page;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleService extends IService<RolePo> {

    /**
     * 通过id查询角色
     *
     * @param id
     * @return
     */
    RoleDto findById(Long id);

    Boolean save(RoleDto roleDto);

    /**
     * 条件查询
     */
    Page<RoleDto> query(RoleDto roleDto);
}
