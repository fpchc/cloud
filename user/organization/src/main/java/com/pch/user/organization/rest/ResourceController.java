package com.pch.user.organization.rest;

import com.pch.common.response.CommonResult;
import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.service.ResourceService;
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
@RestController
@Api(tags = "资源管理")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("通过id查询权限")
    @GetMapping("/permission/{id}")
    public CommonResult<ResourcesDto> findById(@PathVariable Long id) {
        return CommonResult.success(resourceService.findById(id));
    }

    @ApiOperation("添加权限")
    @PostMapping("/permission")
    public CommonResult<Long> add(@Valid @RequestBody ResourcesDto resourcesDto) {
        return CommonResult.success(resourceService.add(resourcesDto));
    }
}
