package com.pch.user.organization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.user.organization.model.dto.ResourceDto;
import com.pch.user.organization.model.po.ResourcePo;
import com.pch.user.organization.model.query.ResourcePage;
import java.util.List;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface ResourceService extends IService<ResourcePo> {

    /**
     * 获取关联用户权限
     *
     * @param userId 用户id
     */
    List<ResourceDto> findByUserId(Long userId);

    ResourceDto findById(Long id);

    Boolean add(ResourceDto resourceDto);

    /**
     * 查询所有资源
     */
    List<ResourceDto> conditionQuery(ResourcePage resourcePage);

    /**
     * 通过username查询资源
     *
     * @param username  用户名
     */
    List<ResourceDto> findByUsername(String username);
}
