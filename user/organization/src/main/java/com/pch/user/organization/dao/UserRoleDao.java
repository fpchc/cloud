package com.pch.user.organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.user.organization.model.po.UserRolePo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface UserRoleDao extends BaseMapper<UserRolePo> {

    List<UserRolePo> findByUserId(Long userId);
}
