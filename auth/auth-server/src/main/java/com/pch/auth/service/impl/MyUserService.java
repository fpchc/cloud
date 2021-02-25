package com.pch.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.pch.auth.exceaption.CustomOauthException;
import com.pch.auth.exceaption.PermissionNotFoundException;
import com.pch.auth.model.domain.PermissionPo;
import com.pch.auth.model.domain.UserPo;
import com.pch.auth.service.PermissionService;
import com.pch.auth.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: admin
 * @Date: 2021/2/23
 */
@Slf4j
@Service("myUserDetailsService")
public class MyUserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPo userPo = userService.loadByUsername(username);
        if (null == userPo) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username + "username is not exist");
        }
        List<PermissionPo> permissionPos = permissionService.findByUserId(userPo.getId());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (CollectionUtils.isEmpty(permissionPos)) {
            throw new PermissionNotFoundException("this user bind permission is not exist");
        }
        for (PermissionPo permissionPo : permissionPos) {
            authorityList.add(new SimpleGrantedAuthority(permissionPo.getCode()));
        }
        return new User(username, passwordEncoder.encode(userPo.getPassword()), authorityList);
    }
}
