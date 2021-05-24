package com.pch.user.organization.model.po;

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
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("tb_user_role")
public class UserRolePo extends BasePo {

    private static final long serialVersionUID = -1810195806444298544L;

    private Long userId;

    private Long roleId;
}
