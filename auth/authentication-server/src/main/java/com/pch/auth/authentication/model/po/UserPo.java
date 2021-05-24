package com.pch.auth.authentication.model.po;

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
@TableName("tb_user")
public class UserPo extends BasePo {

    private static final long serialVersionUID = -8692760072307721060L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * tell
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * true 启用
     */
    private Boolean enable;

    /**
     * 账户是否启用 true 没有过期
     */
    private Boolean accountNonExpired;

    /**
     * 账户是否锁定 true 没有锁定
     */
    private Boolean accountNonLocked;


}
