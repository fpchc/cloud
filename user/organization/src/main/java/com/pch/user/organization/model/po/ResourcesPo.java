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
@Entity
@Setter
@Getter
@EntityListeners({ AuditingEntityListener.class })
@Table(name = "tb_resources")
public class ResourcesPo extends BasePo {

    private static final long serialVersionUID = 4285835478693487481L;

    /**
     * 代码
     */
    private String code;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    private String url;

    /**
     * 方法
     */
    private String method;

    /**
     * 简介
     */
    private String description;

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