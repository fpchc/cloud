package com.pch.user.organization.model.po;

import com.pch.common.base.BasePo;
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
@Table(name = "tb_role")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RolePo extends BasePo {

    private static final long serialVersionUID = -7136537864183138269L;

    private String name;

    private String code;

    private String description;

}
