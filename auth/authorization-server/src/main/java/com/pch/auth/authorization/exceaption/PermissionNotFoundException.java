package com.pch.auth.authorization.exceaption;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
public class PermissionNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7714295378198249617L;

    public PermissionNotFoundException(String message) {
        super(message);
    }

    public PermissionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
