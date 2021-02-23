package com.pch.auth.service;

import com.pch.auth.domain.UserPo;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserService {

    UserPo loadByUsername(String username);
}
