package com.pch.gateway.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pch.common.base.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> 用户实体 </p>
 *
 * @Author: pch
 * @Date: 2020/12/15 15:58
 */
@Data
@TableName("tb_user")
@EqualsAndHashCode(callSuper = true)
public class UserPo extends BasePo {

    private static final long serialVersionUID = -1267443725645842238L;

    private String username;

    private String password;

    private String telephone;

}

