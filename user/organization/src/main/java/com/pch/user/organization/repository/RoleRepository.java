package com.pch.user.organization.repository;

import com.pch.user.organization.model.po.RolePo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleRepository extends JpaRepository<RolePo, Long> {

}
