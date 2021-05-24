package com.pch.auth.authorization.oauth2;

import com.pch.auth.authorization.mapper.UserMapper;
import com.pch.auth.authorization.model.dto.RoleDto;
import com.pch.auth.authorization.model.po.UserPo;
import com.pch.auth.authorization.service.RoleService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: admin
 * @Date: 2021/2/23
 */
@Slf4j
@Service("myUserDetailsService")
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {

    private final UserMapper userMapper;

    private final RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPo userPo = userMapper.findByUsername(username);
        if (null == userPo) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username + "username is not exist");
        }
        List<RoleDto> roleDtoList = roleService.findByUserId(userPo.getId());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (RoleDto roleDto : roleDtoList) {
            authorityList.add(new SimpleGrantedAuthority((roleDto.getCode())));
        }
        return new User(username, userPo.getPassword(), authorityList);
    }
}
