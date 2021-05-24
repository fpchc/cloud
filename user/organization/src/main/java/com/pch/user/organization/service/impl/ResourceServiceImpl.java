package com.pch.user.organization.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.user.organization.dao.ResourceDao;
import com.pch.user.organization.model.dto.ResourceDto;
import com.pch.user.organization.model.po.ResourcePo;
import com.pch.user.organization.model.po.UserPo;
import com.pch.user.organization.model.query.ResourcePage;
import com.pch.user.organization.service.ResourceService;
import com.pch.user.organization.service.UserService;
import com.pch.user.organization.service.mapstruct.ResourceMapper;
import java.util.List;
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
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, ResourcePo> implements ResourceService {

    private final ResourceDao resourceDao;

    private final UserService userService;

    private final ResourceMapper resourceMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ResourceDto> findByUserId(Long userId) {
        List<ResourcePo> resourcePoList = resourceDao.findByUserId(userId);
        return resourcePoList.stream().map(resourceMapper::poToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResourceDto> conditionQuery(ResourcePage resourcePage) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    @Cached(name = "resource:username:", key = "#username", cacheType = CacheType.REMOTE)
    public List<ResourceDto> findByUsername(String username) {
        UserPo userPo = userService.getOne(new QueryWrapper<UserPo>().eq("username", username));
        List<ResourcePo> resourcePoList = resourceDao.findByUserId(userPo.getId());
        return resourceMapper.poToDtoList(resourcePoList);
    }

    @Override
    @Transactional
    public Boolean add(ResourceDto resourceDto) {
        int insert = resourceDao.insert(resourceMapper.dtoToPo(resourceDto));
        return insert >= 0;
    }

    @Override
    @Transactional(readOnly = true)
    public ResourceDto findById(Long id) {
        ResourcePo resourcePo = resourceDao.selectById(id);
        return resourceMapper.poToDto(resourcePo);
    }
}
