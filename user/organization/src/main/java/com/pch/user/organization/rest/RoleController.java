package com.pch.user.organization.rest;

import com.pch.common.response.CommonResult;
import com.pch.user.organization.model.dto.RoleDto;
import com.pch.user.organization.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("通过id查询角色")
    @GetMapping("/{id}")
    public CommonResult<RoleDto> findById(@PathVariable Long id) {
        return CommonResult.success(roleService.findById(id));
    }

    @ApiOperation("条件查询")
    @GetMapping(value = "query")
    public CommonResult<Page<RoleDto>> query(@Validated RoleDto roleDto) {
        return CommonResult.success(roleService.query(roleDto));
    }

    @ApiOperation("添加角色")
    @PostMapping
    public CommonResult<Boolean> add(@Valid @RequestBody RoleDto roleDto) {
        return CommonResult.success(roleService.save(roleDto));
    }
}
