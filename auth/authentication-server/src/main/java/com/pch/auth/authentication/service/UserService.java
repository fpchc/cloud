package com.pch.auth.authentication.service;

import com.pch.auth.authentication.model.dto.UserRoleDto;
import com.pch.auth.authentication.model.po.UserPo;
import com.pch.auth.authentication.model.vo.UserLoginVO;
import java.util.Optional;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserService {

    Optional<UserPo> loadByUsername(String username);

    Long add(UserLoginVO userVO);

    Boolean bindRoleIds(UserRoleDto userRoleDto);
}
