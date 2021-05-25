package com.pch.gateway.model.query;

import com.pch.common.base.PageQuery;
import com.pch.gateway.model.domain.GatewayRoutePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2021/5/25 9:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GatewayRouteQuery extends PageQuery<GatewayRoutePo> {

    private static final long serialVersionUID = 2377970793023973014L;

    private String id;

    private String uri;

    private String predicates;

    private String filters;

    private String description;
}
