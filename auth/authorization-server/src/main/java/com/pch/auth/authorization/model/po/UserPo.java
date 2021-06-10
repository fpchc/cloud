package com.pch.auth.authorization.model.po;

import com.pch.common.base.BasePo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Data
@Entity
@Table(name = "tb_user")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners({ AuditingEntityListener.class })
public class UserPo extends BasePo {

    private static final long serialVersionUID = -8692760072307721060L;

    /**
     * 用户名
     */
    @Column(length = 32)
    private String username;

    /**
     * 登录名称
     */
    @Column(length = 32)
    private String loginName;

    /**
     * 密码
     */
    @Column(length = 150)
    private String password;

    /**
     * tell
     */
    @Column(length = 32)
    private String telephone;

    /**
     * 邮箱
     */
    @Column(length = 32)
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
