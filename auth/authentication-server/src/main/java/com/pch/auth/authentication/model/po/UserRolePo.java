package com.pch.auth.authentication.model.po;

import com.pch.common.base.BasePo;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_user_role_relation")
public class UserRolePo extends BasePo {

    private static final long serialVersionUID = -1810195806444298544L;

    private Long userId;

    private Long roleId;
}
