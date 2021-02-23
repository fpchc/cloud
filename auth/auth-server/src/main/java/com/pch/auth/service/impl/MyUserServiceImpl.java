package com.pch.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pch.auth.domain.UserPo;
import com.pch.auth.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: admin
 * @Date: 2021/2/23
 */
@Slf4j
@Service
public class MyUserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPo userPo = userService.loadByUsername(username);
        if (null == userPo) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username + "username is not exist");
        }


        return new User(username, passwordEncoder.encode(userPo.getPassword()), null);
    }
}
