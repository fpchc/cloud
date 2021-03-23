package com.pch.auth.authorization.oauth2;

import com.pch.auth.authorization.exceaption.PermissionNotFoundException;
import com.pch.auth.authorization.model.domain.PermissionPo;
import com.pch.auth.authorization.model.domain.UserPo;
import com.pch.auth.authorization.service.PermissionService;
import com.pch.auth.authorization.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @Author: admin
 * @Date: 2021/2/23
 */
@Slf4j
@Service("myUserDetailsService")
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserPo> userPoOptional = userService.loadByUsername(username);
        if (userPoOptional.isEmpty()) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username + "username is not exist");
        }
        UserPo userPo = userPoOptional.get();
        List<PermissionPo> permissionPos = permissionService.findByUserId(userPo.getId());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (CollectionUtils.isEmpty(permissionPos)) {
            throw new PermissionNotFoundException("this user bind permission is not exist");
        }
        for (PermissionPo permissionPo : permissionPos) {
            authorityList.add(new SimpleGrantedAuthority(("ROlE_" + permissionPo.getCode()).toUpperCase()));
        }
        UserDetails userDetails = new User(username, userPo.getPassword(), authorityList);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );
        return userDetails;
    }
}
