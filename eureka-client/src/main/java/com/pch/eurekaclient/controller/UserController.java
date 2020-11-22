package com.pch.eurekaclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.eurekaclient.domain.UserDo;
import com.pch.eurekaclient.response.CommonResult;
import com.pch.eurekaclient.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public CommonResult<List<UserDo>> findAll() {
        List<UserDo> all = userService.findAll();
        return CommonResult.success(all);
    }

}
