package com.pch.auth.authentication.rest;

import com.pch.auth.authentication.service.PermissionService;
import com.pch.common.response.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Api(tags = "权限管理")
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation("添加权限")
    @PostMapping("/auth")
    public CommonResult<Boolean> authPermission() {
        return null;
    }


}
