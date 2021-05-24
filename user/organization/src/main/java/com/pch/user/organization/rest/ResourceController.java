package com.pch.user.organization.rest;

import com.pch.common.response.CommonResult;
import com.pch.user.organization.model.dto.ResourceDto;
import com.pch.user.organization.model.query.ResourcePage;
import com.pch.user.organization.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("通过id查询资源")
    @GetMapping("/{id}")
    public CommonResult<ResourceDto> findById(@PathVariable Long id) {
        return CommonResult.success(resourceService.findById(id));
    }

    @ApiOperation("条件查询")
    @GetMapping("/conditionQuery")
    public CommonResult<List<ResourceDto>> conditionQuery(ResourcePage resourcePage) {
        return CommonResult.success(resourceService.conditionQuery(resourcePage));
    }

    @ApiOperation("添加资源")
    @PostMapping("")
    public CommonResult<Boolean> add(@Valid @RequestBody ResourceDto resourceDto) {
        return CommonResult.success(resourceService.add(resourceDto));
    }

    @ApiOperation("通过username查询")
    @GetMapping("/findByUsername/{username}")
    public CommonResult<List<ResourceDto>> findByUsername(
            @NotBlank(message = "username is null") @PathVariable String username) {
        return CommonResult.success(resourceService.findByUsername(username));
    }
}
