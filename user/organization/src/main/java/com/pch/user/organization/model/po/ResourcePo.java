package com.pch.user.organization.model.po;

import com.pch.common.base.BasePo;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Data
@Entity
@Table(name = "tb_resource")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ResourcePo extends BasePo {

    public static final String RESOURCE_PREFIX = "resource:";

    private static final long serialVersionUID = 4285835478693487481L;

    /**
     * 代码
     */
    private String code;

    /**
     * 类型
     */
    private String type;

    /**
     * 名称
     */
    private String name;

    private String url;

    /**
     * 方法
     */
    private String method;

    /**
     * 简介
     */
    private String description;

}
