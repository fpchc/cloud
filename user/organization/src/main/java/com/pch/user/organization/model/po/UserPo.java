package com.pch.user.organization.model.po;

import com.pch.common.base.BasePo;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Getter
@Setter
@Entity
@Table(name = "tb_user")
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
     * 是否已删除Y：已删除，N：未删除
     */
    private Character deleted;

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

    /**
     * 创建人
     */
    @Column(updatable = false, length = 32)
    private String createBy;

    /**
     * 更新人
     */
    @Column(length = 32)
    private String updatedBy;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    private LocalDateTime updateTime;

}
