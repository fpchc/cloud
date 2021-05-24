package com.pch.user.organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.user.organization.model.po.ResourcePo;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface ResourceDao extends BaseMapper<ResourcePo> {

    List<ResourcePo> findByUserId(@Param("userId") Long userId);

}
