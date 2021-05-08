package com.pch.user.organization.service.mapstruct;

import com.pch.user.organization.model.dto.UserDto;
import com.pch.user.organization.model.po.UserPo;
import com.pch.user.organization.model.vo.UserLoginVO;
import org.mapstruct.Mapper;

/**
 * @Author: pch
 * @Date: 2021/5/8 17:18
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto poToDto(UserPo userPo);

    UserPo dtoToPo(UserDto userDto);

    UserPo userLoginVOToPo(UserLoginVO userLoginVO);

}
