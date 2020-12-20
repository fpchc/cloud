package com.pch.gateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pch.gateway.mapper.UserMapper;
import com.pch.gateway.model.domain.UserPo;
import com.pch.gateway.service.UserService;

/**
 * <P> user 业务具体实现 </P>
 * @Author: pch
 * @Date: 2020-12-20 14:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insert(UserPo userPo) {
        return userMapper.insert(userPo);
    }
}
