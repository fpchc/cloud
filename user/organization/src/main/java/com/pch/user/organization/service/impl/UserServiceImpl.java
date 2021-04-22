package com.pch.user.organization.service.impl;

import com.pch.common.exception.ServiceException;
import com.pch.user.organization.model.dto.UserRoleDto;
import com.pch.user.organization.model.po.UserPo;
import com.pch.user.organization.model.po.UserRolePo;
import com.pch.user.organization.model.vo.UserLoginVO;
import com.pch.user.organization.repository.UserRepository;
import com.pch.user.organization.repository.UserRoleRepository;
import com.pch.user.organization.service.UserService;
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

}
