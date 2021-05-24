package com.pch.auth.authentication.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.auth.authentication.model.po.UserPo;
import java.util.Optional;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserMapper extends BaseMapper<UserPo> {

    Optional<UserPo> findByUsername(String username);
}
