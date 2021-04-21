package com.pch.gateway.mapper;

import com.pch.gateway.model.domain.GatewayRoutePo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: pch
 * @Date: 2021/01/19 15:28
 */
public interface RouteRepository extends JpaRepository<GatewayRoutePo, String> {

}
