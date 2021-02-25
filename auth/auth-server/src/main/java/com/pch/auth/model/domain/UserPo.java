package com.pch.auth.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.pch.common.base.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Data
@Entity
@Table(name = "tb_user")
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
     * 状态
     */
    private Short status;

    /**
     * 启用禁用
     */
    private Boolean enable;

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
