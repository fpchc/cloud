package com.pch.auth.authorization.rest;

import com.pch.auth.authorization.model.dto.PermissionDto;
import com.pch.auth.authorization.service.PermissionService;
import com.pch.common.response.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @ApiOperation("通过id查询权限")
    @GetMapping("/permission/{id}")
    public CommonResult<PermissionDto> findById(@PathVariable Long id) {
        return CommonResult.success(permissionService.findById(id));
    }

    @ApiOperation("添加权限")
    @PostMapping("/permission")
    public CommonResult<Long> add(@Valid @RequestBody PermissionDto permissionDto) {
        return CommonResult.success(permissionService.add(permissionDto));
    }
}
