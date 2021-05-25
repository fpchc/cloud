package com.pch.common.base;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

/**
 * @Author: pch
 * @Date: 2021/5/25 10:15
 */
@Getter
@Setter
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = -6048954381398026216L;

    private Integer current = 1;

    private Integer pageSize = 10;

    private List<OrderItem> orderItems;

    public Page<T> of() {
        Page<T> page = new Page<>(current, pageSize);
        if (!CollectionUtils.isEmpty(orderItems)) {
            page.setOrders(orderItems);
        }
        return page;
    }



}
