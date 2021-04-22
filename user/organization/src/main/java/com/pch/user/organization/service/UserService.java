package com.pch.user.organization.service;

import com.pch.user.organization.model.dto.UserRoleDto;
import com.pch.user.organization.model.po.UserPo;
import com.pch.user.organization.model.vo.UserLoginVO;
import java.util.Optional;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserService {

    Long add(UserLoginVO userVO);

    Boolean bindRoleIds(UserRoleDto userRoleDto);
}
