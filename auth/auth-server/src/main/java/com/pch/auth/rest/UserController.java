package com.pch.auth.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.auth.model.dto.UserDto;
import com.pch.auth.model.dto.UserRoleDto;
import com.pch.auth.model.vo.UserVO;
import com.pch.auth.service.UserService;
import com.pch.common.response.CommonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Api(tags = "用户管理")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("添加用户")
    public CommonResult<Long> add(@Valid @RequestBody UserDto userDto) {
        return CommonResult.success(userService.add(userDto));
    }

    @PostMapping(value = "/user/bindRole", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("用户绑定角色")
    public CommonResult<Boolean> bindRoleIds(@Valid @RequestBody UserRoleDto userRoleDto) {
        return CommonResult.success(userService.bindRoleIds(userRoleDto));
    }

    @PostMapping(value = "/user/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<String> login(@Valid @RequestBody UserVO userVO) {
        return CommonResult.success(userService.login(userVO));
    }
}
