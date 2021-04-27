package com.pch.auth.authentication.service;

import com.pch.auth.authentication.model.dto.ResourceDto;
import com.pch.auth.authentication.model.po.ResourcesPo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface ResourcesService {

    /**
     * 获取关联用户权限
     *
     * @param userId 用户id
     * @return
     */
    List<ResourcesPo> findByUserId(Long userId);

    ResourceDto findById(Long id);

    Long add(ResourceDto resourceDto);

    /**
     * 认证 token 是否具备访问权限.
     *
     * @param request HttpServletRequest
     * @param url     请求url
     * @param method  请求方法
     */
    Boolean authentication(HttpServletRequest request, String url, String method);
}
