package com.pch.auth.authentication.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2021/5/4 15:53
 */
@Getter
@Setter
public class HttpServletRequestAuthWrapper extends HttpServletRequestWrapper {

    private String url;

    private String method;

    public HttpServletRequestAuthWrapper(HttpServletRequest request, String url, String method) {
        super(request);
        this.url = url;
        this.method = method;
    }
}
