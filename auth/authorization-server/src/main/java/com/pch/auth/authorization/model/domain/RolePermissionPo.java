package com.pch.auth.authorization.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pch.common.base.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_role_permission")
public class RolePermissionPo extends BasePo {

    private static final long serialVersionUID = 7402412601579098788L;

    private Long roleId;

    private Long permissionId;
}
