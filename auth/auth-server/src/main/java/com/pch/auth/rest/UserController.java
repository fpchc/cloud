package com.pch.auth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.response.CommonResult;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public CommonResult<String> get() {
        return CommonResult.success();
    }
}
