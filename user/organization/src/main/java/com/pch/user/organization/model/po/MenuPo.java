package com.pch.user.organization.model.po;

import com.pch.common.base.BasePo;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Author: pch
 * @Date: 2021/4/23 11:31
 */
@Getter
@Setter
@Entity
@Table(name = "tb_menu")
@EntityListeners({ AuditingEntityListener.class })
public class MenuPo extends BasePo {

    private static final long serialVersionUID = -9071904504678294333L;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 菜单类型 （1:菜单）
     */
    private Short type;

    /**
     * 菜单路径
     */
    private String href;

    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;
    /**
     * 菜单顺序
     */
    private Integer orderNum;


}
