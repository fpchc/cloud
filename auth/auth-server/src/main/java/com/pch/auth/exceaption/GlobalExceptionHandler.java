package com.pch.auth.exceaption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pch.common.exception.DefaultGlobalExceptionHandlerAdvice;
import com.pch.common.exception.ServiceException;
import com.pch.common.response.CommonResult;

/**
 * <P> 全局异常 </P>
 *
 * @Author: pch
 * @Date: 2020/12/31 16:02
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultGlobalExceptionHandlerAdvice {

    /**
     * 处理业务异常
     *
     * @param serviceException  业务异常
     * @return Mono<CommonResult < Boolean>>
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public CommonResult<Boolean> serviceExceptionHandler(ServiceException serviceException) {
        return CommonResult.failed(serviceException.getCode(), serviceException.getMessage());
    }
}
