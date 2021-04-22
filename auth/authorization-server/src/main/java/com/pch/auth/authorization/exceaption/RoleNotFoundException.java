package com.pch.auth.authorization.exceaption;

/**
 * @Author: pch
 * @Date: 2021/4/22 16:39
 */
public class RoleNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 4063285652208969331L;


    public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
