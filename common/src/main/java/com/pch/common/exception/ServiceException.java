package com.pch.common.exception;

import com.pch.common.constant.SysState;
import lombok.Getter;
import lombok.Setter;

/**
 * 服务类异常处理
 */
@Getter
@Setter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 820763453066753527L;

    /**
     * 错误编码
     */
    private String code;

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(SysState sysState) {
        super(sysState.getError());
        this.code = sysState.getCode();
    }
}
