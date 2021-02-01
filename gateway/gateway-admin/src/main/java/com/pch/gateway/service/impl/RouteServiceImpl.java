package com.pch.gateway.service.impl;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.gateway.mapper.RouteMapper;
import com.pch.gateway.service.RouteService;

/**
 * @Author: pch
 * @Date: 2021/01/19 15:27
 */
@Service
public class RouteServiceImpl extends
        ServiceImpl<RouteMapper, RouteDefinition> implements RouteService {
}
