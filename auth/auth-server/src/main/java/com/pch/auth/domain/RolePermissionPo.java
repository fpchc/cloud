package com.pch.auth.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pch.common.base.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(schema = "permission", name = "tb_role_permission")
public class RolePermissionPo extends BasePo {
    private static final long serialVersionUID = 7402412601579098788L;

    private Long roleId;

    private Long permissionId;
}
