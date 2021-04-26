package com.pch.user.organization.model.po;

import com.pch.common.base.BasePo;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2021/4/23 16:08
 */
@Getter
@Setter
public class UserMenuPo extends BasePo {

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
