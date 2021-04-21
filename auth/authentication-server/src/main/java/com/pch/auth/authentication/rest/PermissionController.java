package com.pch.auth.authentication.rest;

import com.pch.common.response.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: pch
 * @Date: 2021/4/19 17:27
 */
@RestController
public class PermissionController {

    @GetMapping("/get")
    public CommonResult<String> getString() {
        return CommonResult.success("success");
    }

}
