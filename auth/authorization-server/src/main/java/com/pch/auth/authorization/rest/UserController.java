package com.pch.auth.authorization.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pch.auth.authorization.model.dto.UserRoleDto;
import com.pch.auth.authorization.model.vo.UserVO;
import com.pch.auth.authorization.service.UserService;
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
    public CommonResult<Long> add(@Valid @RequestBody UserVO userVO) {
        return CommonResult.success(userService.add(userVO));
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("添加用户")
    public CommonResult<Long> add(@Valid @RequestBody List<UserVO> userVOs) {
        return CommonResult.success();
    }

    @PostMapping(value = "/user/bindRole", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("用户绑定角色")
    public CommonResult<Boolean> bindRoleIds(@Valid @RequestBody UserRoleDto userRoleDto) {
        return CommonResult.success(userService.bindRoleIds(userRoleDto));
    }

    @PostMapping(value = "/user/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("用户登录")
    public CommonResult<String> login(@Valid @RequestBody UserVO userVO) {
        return CommonResult.success(userService.login(userVO));
    }
}
