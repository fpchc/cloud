package com.pch.eurekaclient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pch.eurekaclient.domain.UserDo;
import com.pch.eurekaclient.mapper.UserMapper;
import com.pch.eurekaclient.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<UserDo> findAll() {
        return userMapper.findAll();
    }
}
