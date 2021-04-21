package com.pch.auth.authorization.rest;

import com.pch.auth.authorization.model.dto.RoleDto;
import com.pch.auth.authorization.service.RoleService;
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
@Api(tags = "角色管理")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("通过id查询角色")
    @GetMapping("/role/{id}")
    public CommonResult<RoleDto> findById(@PathVariable Long id) {
        return CommonResult.success(roleService.findById(id));
    }

    @ApiOperation("添加角色")
    @PostMapping("/role")
    public CommonResult<Long> add(@Valid @RequestBody RoleDto roleDto) {
        return CommonResult.success(roleService.save(roleDto));
    }
}
