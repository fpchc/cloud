package com.pch.auth.authentication.provide;

import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.provide.back.ResourceProvideFallBack;
import com.pch.common.response.CommonResult;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: pch
 * @Date: 2021/5/6 17:01
 */
@FeignClient(name = "organization-service", fallback = ResourceProvideFallBack.class)
public interface ResourceProvide {

    @GetMapping("/organization/resource/findAll")
    CommonResult<List<ResourceDto>> findAll();

    @GetMapping("/organization/resource/findByUsername/{username}")
    CommonResult<List<ResourceDto>> findByUsername(@PathVariable("username") String username);
}
