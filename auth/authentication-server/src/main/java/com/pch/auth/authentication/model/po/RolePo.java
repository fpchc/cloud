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
@ToString(callSuper = true)
@TableName("tb_role")
@EqualsAndHashCode(callSuper = true)
public class RolePo extends BasePo {

    private static final long serialVersionUID = -7136537864183138269L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private String code;

    private String description;


}
