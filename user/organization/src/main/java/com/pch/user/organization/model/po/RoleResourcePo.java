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
 * @Date: 2020/9/11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("tb_role_resource")
public class RoleResourcePo extends BasePo {

    private static final long serialVersionUID = 7402412601579098788L;

    private Long roleId;

    private Long resourceId;
}
