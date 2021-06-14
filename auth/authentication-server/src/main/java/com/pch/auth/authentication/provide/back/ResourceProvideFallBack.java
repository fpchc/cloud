package com.pch.auth.authentication.provide.back;

import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.provide.ResourceProvide;
import com.pch.common.response.CommonResult;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2021/5/6 17:04
 */
@Slf4j
public class ResourceProvideFallBack implements ResourceProvide {

    @Override
    public CommonResult<List<ResourceDto>> findAll() {
        log.error("远程调用organization服务异常, 请求方位为：{}", "/resource/findALl");
        return CommonResult.failed();
    }

    @Override
    public CommonResult<List<ResourceDto>> findByUsername(String username) {
        log.error("远程调用organization服务异常, 请求方位为：{}", "/resource/findByUsername");
        return CommonResult.failed();
    }
}
