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
@Table(name = "tb_user_role")
public class UserRolePo extends BasePo {

    private static final long serialVersionUID = -1810195806444298544L;

    private Long userId;

    private Long roleId;
}
