package com.pch.gateway.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.gateway.model.domain.GatewayRoutePo;

/**
 * @Author: pch
 * @Date: 2021/01/19 15:28
 */
public interface RouteRepository extends JpaRepository<GatewayRoutePo, String> {

}
