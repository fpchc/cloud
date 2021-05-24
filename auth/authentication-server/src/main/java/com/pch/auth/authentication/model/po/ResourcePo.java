package com.pch.auth.authentication.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pch.common.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Data
@TableName("tb_resource")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ResourcePo extends BasePo {

    private static final long serialVersionUID = 4285835478693487481L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

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
