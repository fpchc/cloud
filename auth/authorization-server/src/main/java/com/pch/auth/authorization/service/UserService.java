package com.pch.auth.authorization.service;

import com.pch.auth.authorization.model.po.UserPo;
import com.pch.auth.authorization.model.dto.UserRoleDto;
import com.pch.auth.authorization.model.vo.UserLoginVO;
import java.util.Optional;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserService {

    Optional<UserPo> loadByUsername(String username);

    Long add(UserLoginVO userVO);

    Boolean bindRoleIds(UserRoleDto userRoleDto);

    String login(UserLoginVO userVO);
}
