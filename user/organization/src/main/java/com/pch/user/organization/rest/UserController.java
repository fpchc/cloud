package com.pch.user.organization.rest;

import com.pch.common.response.CommonResult;
import com.pch.user.organization.model.dto.UserRoleDto;
import com.pch.user.organization.model.vo.UserLoginVO;
import com.pch.user.organization.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Api(tags = "用户管理")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("添加用户")
    public CommonResult<Boolean> add(@Valid @RequestBody UserLoginVO userVO) {
        return CommonResult.success(userService.add(userVO));
    }

    @PostMapping(value = "/bindRole", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("用户绑定角色")
    public CommonResult<Boolean> bindRoleIds(@Valid @RequestBody UserRoleDto userRoleDto) {
        return CommonResult.success(userService.bindRoleIds(userRoleDto));
    }

}
