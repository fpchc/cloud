package com.pch.auth.service;

import com.pch.auth.model.dto.UserDto;
import com.pch.auth.model.domain.UserPo;
import com.pch.auth.model.dto.UserRoleDto;
import com.pch.auth.model.vo.UserVO;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserService {

    UserPo loadByUsername(String username);

    Long add(UserDto userDto);

    Boolean bindRoleIds(UserRoleDto userRoleDto);

    String login(UserVO userVO);
}
