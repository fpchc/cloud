package com.pch.auth.authorization.service.impl;

import com.pch.auth.authorization.oauth2.MyUserService;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.pch.auth.authorization.repository.UserRepository;
import com.pch.auth.authorization.repository.UserRoleRepository;
import com.pch.auth.authorization.service.UserService;
import com.pch.auth.authorization.model.domain.UserRolePo;
import com.pch.auth.authorization.model.dto.UserRoleDto;
import com.pch.auth.authorization.model.vo.UserLoginVO;
import com.pch.auth.authorization.model.domain.UserPo;
import com.pch.common.exception.ServiceException;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserService myUserService;

    @Override
    @Transactional
    public Long add(UserLoginVO userVO) {
        Optional<UserPo> byUsername = userRepository.findByUsername(userVO.getUsername());
        if (byUsername.isPresent()) {
            throw new ServiceException("", "");
        }
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userVO, userPo);
        userPo.setPassword(passwordEncoder.encode(userPo.getPassword()));
        userPo.setEnable(true);
        UserPo save = userRepository.save(userPo);
        return save.getId();
    }

    @Override
    public String login(UserLoginVO userVO) {
        Optional<UserPo> byUsername = userRepository.findByUsername(userVO.getUsername());
        if (byUsername.isEmpty()) {
            throw new UsernameNotFoundException("username is not exist");
        }
        byUsername.ifPresent(userPo -> {
            if (!passwordEncoder.matches(userVO.getPassword(), userPo.getPassword())) {
                throw new ServiceException("", "password is not matches");
            }
            UserDetails userDetails = myUserService.loadUserByUsername(userVO.getUsername());
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });
        return "success";
    }

    @Override
    @Transactional
    public Boolean bindRoleIds(UserRoleDto userRoleDto) {
        List<UserRolePo> list = new ArrayList<>();
        List<Long> roleIds = userRoleDto.getRoleIds();
        roleIds.forEach(roleId -> {
            UserRolePo userRolePo = new UserRolePo();
            userRolePo.setUserId(userRoleDto.getUserId());
            userRolePo.setRoleId(roleId);
            list.add(userRolePo);
        });
        List<UserRolePo> list1 = userRoleRepository.saveAll(list);
        return !CollectionUtils.isEmpty(list1);
    }

    @Override
    public Optional<UserPo> loadByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
