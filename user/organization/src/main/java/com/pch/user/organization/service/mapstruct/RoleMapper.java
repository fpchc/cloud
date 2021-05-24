package com.pch.user.organization.service.mapstruct;

import com.pch.user.organization.model.dto.RoleDto;
import com.pch.user.organization.model.po.RolePo;
import org.mapstruct.Mapper;

/**
 * @Author: pch
 * @Date: 2021/5/18 18:00
 */
@Mapper
public interface RoleMapper extends BaseMapper<RolePo, RoleDto> {



}
