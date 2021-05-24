package com.pch.user.organization.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pch.common.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2021/4/23 16:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("tb_role_menu")
public class RoleMenuPo extends BasePo {

    private static final long serialVersionUID = 3297813232420099633L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 菜单id
     */
    private Long menuId;
}
