package com.pch.user.organization.service;

import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.model.po.ResourcesPo;
import java.util.List;

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

    ResourcesDto findById(Long id);

    Long add(ResourcesDto resourcesDto);
}
