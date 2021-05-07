package com.pch.user.organization.rest;

import com.pch.common.response.CommonResult;
import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@Api(tags = "资源管理")
@RequestMapping("/permission")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("通过id查询资源")
    @GetMapping("/{id}")
    public CommonResult<ResourcesDto> findById(@PathVariable Long id) {
        return CommonResult.success(resourceService.findById(id));
    }

    @ApiOperation("查询所有资源")
    @GetMapping("/findAll")
    public CommonResult<List<ResourcesDto>> findAll() {
        return CommonResult.success(resourceService.findAll());
    }

    @ApiOperation("添加资源")
    @PostMapping("")
    public CommonResult<Long> add(@Valid @RequestBody ResourcesDto resourcesDto) {
        return CommonResult.success(resourceService.add(resourcesDto));
    }
}
