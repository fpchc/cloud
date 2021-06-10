package com.pch.user.organization.model.po;

import com.pch.common.base.BasePo;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2021/4/23 16:08
 */
@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_role_menu_relation")
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
