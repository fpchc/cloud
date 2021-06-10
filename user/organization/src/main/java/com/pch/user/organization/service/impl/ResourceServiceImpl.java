package com.pch.user.organization.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.model.po.ResourcePo;
import com.pch.user.organization.repository.ResourceRepository;
import com.pch.user.organization.repository.UserRepository;
import com.pch.user.organization.service.ResourceService;
import com.pch.user.organization.service.mapstruct.ResourceMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    private final ResourceMapper resourceMapper;

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ResourcesDto> findByUserId(Long userId) {
        List<ResourcePo> resourcePoList = resourceRepository.findByUserId(userId);
        return resourcePoList.stream().map(resourceMapper::poToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResourcesDto> findAll() {
        List<ResourcePo> resourcePosFromDateBase = resourceRepository.findAll();
        return resourcePosFromDateBase.stream().map(resourceMapper::poToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cached(name = "resource:username:", key = "#username", cacheType = CacheType.REMOTE)
    public List<ResourcesDto> findByUsername(String username) {
        List<ResourcePo> resourcePoList = resourceRepository.findByUsername(username);
        return resourceMapper.poToDtoList(resourcePoList);
    }

    @Override
    @Transactional
    public Long add(ResourcesDto resourcesDto) {
        ResourcePo resourcePo = resourceRepository.save(resourceMapper.dtoToPo(resourcesDto));
        return resourcePo.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public ResourcesDto findById(Long id) {
        Optional<ResourcePo> permissionPo = resourceRepository.findById(id);
        return permissionPo.map(resourceMapper::poToDto).orElse(null);
    }
}
