package com.pch.auth.authentication.model.po;

import com.pch.common.base.BasePo;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Getter
@Setter
@Entity
@Table(name = "tb_user_role_relation")
public class UserRolePo extends BasePo {

    private static final long serialVersionUID = -1810195806444298544L;

    private Long userId;

    private Long roleId;
}
