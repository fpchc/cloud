package com.pch.user.organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.user.organization.model.po.UserRolePo;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Mapper
public interface UserRoleDao extends BaseMapper<UserRolePo> {

    List<UserRolePo> findByUserId(Long userId);
}
