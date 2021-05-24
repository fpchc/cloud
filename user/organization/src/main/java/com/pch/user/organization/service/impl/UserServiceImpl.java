package com.pch.user.organization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.common.exception.ServiceException;
import com.pch.user.organization.dao.UserDao;
import com.pch.user.organization.dao.UserRoleDao;
import com.pch.user.organization.model.dto.UserRoleDto;
import com.pch.user.organization.model.po.UserPo;
import com.pch.user.organization.model.po.UserRolePo;
import com.pch.user.organization.model.vo.UserLoginVO;
import com.pch.user.organization.service.UserService;
import com.pch.user.organization.service.mapstruct.UserMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserDao, UserPo> implements UserService {

    private final UserDao userDao;

    private final UserMapper userMapper;

    private final UserRoleDao userRoleDao;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Boolean add(UserLoginVO userVO) {
        UserPo byUsername = userDao.findByUsername(userVO.getUsername());
        if (byUsername != null) {
            throw new ServiceException("", "");
        }
        UserPo userPo = userMapper.userLoginVOToPo(userVO);
        userPo.setPassword(passwordEncoder.encode(userPo.getPassword()));
        userPo.setEnable(true);
        userPo.setDeleted('N');
        userPo.setAccountNonExpired(true);
        userPo.setAccountNonLocked(true);
        int i = userDao.insert(userPo);
        return i >= 0;
    }

    @Override
    @Transactional
    public Boolean bindRoleIds(UserRoleDto userRoleDto) {
        List<Long> roleIds = userRoleDto.getRoleIds();
        roleIds.forEach(roleId -> {
            UserRolePo userRolePo = new UserRolePo();
            userRolePo.setUserId(userRoleDto.getUserId());
            userRolePo.setRoleId(roleId);
            userRoleDao.insert(userRolePo);
        });
        return true;
    }

}
