package com.pch.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * 换回异常类
 */
public enum SysState {

    upload_err("1000", "上传失败"),

    /*** user相关service错误编码 */
    user_exist("40000001", "登录名已存在"),
    user_telephone_exist("40000002", "手机号已存在"),
    user_email_exist("40000003", "邮箱已存在"),
    user_id_not_exist("40000004", "用户id不存在"),
    user_login_name_exist("40000005", "用户登录名称已存在"),

    /**业务相关*/

    ;

    private final String code;

    private final String message;

    SysState(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getError() {
        return message;
    }

    public static SysState value(String code) {
        for (SysState e : SysState.values()) {
            if (StringUtils.equalsIgnoreCase(code, e.getCode())) {
                return e;
            }
        }
        return null;
    }
}
