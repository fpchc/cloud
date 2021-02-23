package com.pch.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pch.auth.domain.UserPo;
import com.pch.auth.repository.UserRepository;
import com.pch.auth.service.UserService;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserPo loadByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
