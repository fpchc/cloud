package com.pch.gateway.model.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pch.common.base.BaseDto;
import com.pch.gateway.model.domain.GatewayRoutePo;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

/**
 * @Author: pch
 * @Date: 2021/2/18
 */
@Slf4j
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GatewayRouteDto extends BaseDto {

    private static final long serialVersionUID = -6945274367384292505L;

    @NotBlank(message = "路由id不能为空")
    private String id;

    @NotEmpty(message = "网关断言不能为空")
    private List<PredicateDefinition> predicates = new ArrayList<>();

    private List<FilterDefinition> filters = new ArrayList<>();

    @NotBlank(message = "uri不能为空")
    private String uri;

    private Integer orders = 0;

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
