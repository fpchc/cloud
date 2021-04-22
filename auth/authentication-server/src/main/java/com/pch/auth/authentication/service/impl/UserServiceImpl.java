package com.pch.auth.authentication.service.impl;

import com.pch.auth.authentication.model.dto.UserRoleDto;
import com.pch.auth.authentication.model.po.UserPo;
import com.pch.auth.authentication.model.po.UserRolePo;
import com.pch.auth.authentication.model.vo.UserLoginVO;
import com.pch.auth.authentication.repository.UserRepository;
import com.pch.auth.authentication.repository.UserRoleRepository;
import com.pch.auth.authentication.service.UserService;
import com.pch.common.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

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
