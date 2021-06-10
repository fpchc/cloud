package com.pch.user.organization.model.po;

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
@Table(name = "tb_user")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserPo extends BasePo {

    private static final long serialVersionUID = -8692760072307721060L;

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
     * 是否已删除Y：已删除，N：未删除
     */
    private Character deleted;

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
