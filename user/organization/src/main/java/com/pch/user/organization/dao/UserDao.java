package com.pch.user.organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.user.organization.model.po.UserPo;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserDao extends BaseMapper<UserPo> {

    UserPo findByUsername(String username);
}
