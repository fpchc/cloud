package com.pch.user.organization.service;

import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.model.po.ResourcePo;
import java.util.List;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface ResourceService {

    /**
     * 获取关联用户权限
     *
     * @param userId 用户id
     */
    List<ResourcePo> findByUserId(Long userId);

    ResourcesDto findById(Long id);

    Long add(ResourcesDto resourcesDto);

    /**
     * 查询所有资源
     */
    List<ResourcesDto> findAll();
}
