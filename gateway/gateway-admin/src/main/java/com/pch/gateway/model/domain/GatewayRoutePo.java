package com.pch.gateway.model.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <P> 路由实体 </P>
 *
 * @Author: pch
 * @Date: 2021/2/18
 */
@Data
@TableName("tb_gateway_route")
public class GatewayRoutePo implements Serializable {

    private static final long serialVersionUID = -4043749724295641961L;

    @TableId
    private String id;

    private String uri;

    private String predicates;

    private String filters;

    private String description;

    private Integer orders = 0;

    private String status = "Y";

    @Version
    private Integer version;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;


}
