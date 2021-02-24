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
@Table(name = "tb_user_role")
public class UserRolePo extends BasePo {
    private static final long serialVersionUID = -1810195806444298544L;

    private Long userId;

    private Long roleId;
}
