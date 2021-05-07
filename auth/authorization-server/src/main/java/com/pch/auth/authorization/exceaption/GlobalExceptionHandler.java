package com.pch.auth.authorization.exceaption;

import com.pch.common.exception.DefaultGlobalExceptionHandlerAdvice;
import com.pch.common.response.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <P> 全局异常 </P>
 *
 * @Author: pch
 * @Date: 2020/12/31 16:02
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultGlobalExceptionHandlerAdvice {

    /**
     * 角色不存在异常
     *
     * @param roleNotFoundException roleNotFoundException
     */
    @ExceptionHandler(RoleNotFoundException.class)
    public CommonResult<Boolean> roleNotFoundExceptionHandler(RoleNotFoundException roleNotFoundException) {
        return CommonResult.failed(roleNotFoundException.getMessage());
    }

}
