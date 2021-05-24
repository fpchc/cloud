package com.pch.user.organization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.user.organization.model.dto.UserRoleDto;
import com.pch.user.organization.model.po.UserPo;
import com.pch.user.organization.model.vo.UserLoginVO;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserService extends IService<UserPo> {

    Boolean add(UserLoginVO userVO);

    Boolean bindRoleIds(UserRoleDto userRoleDto);
}
