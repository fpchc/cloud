package com.pch.auth.authentication.rest;

import com.pch.auth.authentication.service.ResourcesService;
import com.pch.common.response.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Api(tags = "权限管理")
@RestController
@RequestMapping("/resource")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @ApiOperation("认证")
    @PostMapping("/authentication")
    public CommonResult<Boolean> authentication(@RequestParam("url") String url,
            @RequestParam("method") String method, HttpServletRequest request) {
        return CommonResult.success(resourcesService.authentication(request, url, method));
    }


}
