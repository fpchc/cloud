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
@Table(name = "tb_role")
@EntityListeners({ AuditingEntityListener.class })
public class RolePo extends BasePo {

    private static final long serialVersionUID = -7136537864183138269L;

    private String name;

    private String code;

    private String description;

}
