package com.pch.auth.authorization.service;

import com.pch.auth.authorization.model.domain.UserPo;
import com.pch.auth.authorization.model.dto.UserRoleDto;
import com.pch.auth.authorization.model.vo.UserVO;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserService {

    UserPo loadByUsername(String username);

    Long add(UserVO userVO);

    Boolean bindRoleIds(UserRoleDto userRoleDto);

    String login(UserVO userVO);
}
