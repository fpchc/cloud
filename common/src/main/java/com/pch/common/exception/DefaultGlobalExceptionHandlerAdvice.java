package com.pch.common.exception;

import com.pch.common.response.CommonResult;
import com.pch.common.response.ResultCode;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    public CommonResult<Boolean> BindExceptionHandler(BindException e) {
        log.error("bind validate exception:", e);
        String message = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(",", "", ""));
        return CommonResult.validateFailed(message);
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<Boolean> MethodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException e) {
        log.error("method argument not valid exception:", e);
        String message = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(",", "", ""));
        return CommonResult.validateFailed(message);
    }

    /**
     * 处理业务异常
     *
     * @param serviceException 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public CommonResult<Boolean> serviceExceptionHandler(ServiceException serviceException) {
        log.error("service exception:", serviceException);
        return CommonResult.failed(serviceException.getCode(), serviceException.getMessage());
    }

    /**
     * 默认全局异常处理
     *
     * @param ex    ex
     */
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<Boolean> exception(Exception ex) {
        log.error("global exception:", ex);
        return CommonResult.failed(ResultCode.FAILED.getCode(), ex.getMessage());
    }
}
