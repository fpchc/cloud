package com.pch.gateway.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.BeanUtils;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pch.common.base.BaseDto;
import com.pch.gateway.model.domain.GatewayRoutePo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2021/2/18
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRouteDto extends BaseDto {

    private static final long serialVersionUID = -6945274367384292505L;

    @NotEmpty(message = "网关断言不能为空")
//    @ApiModelProperty(value = "网关断言")
    private List<PredicateDefinition> predicates = new ArrayList<>();

//    @ApiModelProperty(value = "网关过滤器信息")
    private List<FilterDefinition> filters = new ArrayList<>();

    @NotBlank(message = "uri不能为空")
//    @ApiModelProperty(value = "网关uri")
    private String uri;

    @NotBlank(message = "路由id不能为空")
//    @ApiModelProperty(value = "网关路由id")
    private String routeId;

//    @ApiModelProperty(value = "排序")
    private Integer orders = 0;

//    @ApiModelProperty(value = "网关路由描述信息")
    private String description;

    public GatewayRoutePo toPo() {
        GatewayRoutePo gatewayRoutePo = new GatewayRoutePo();
        BeanUtils.copyProperties(this, gatewayRoutePo);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            gatewayRoutePo.setFilters(objectMapper.writeValueAsString(filters));
            gatewayRoutePo.setPredicates(objectMapper.writeValueAsString(predicates));
        } catch (JsonProcessingException e) {
            log.error("断言或者过滤器配置异常", e);
        }
        return gatewayRoutePo;
    }
}
