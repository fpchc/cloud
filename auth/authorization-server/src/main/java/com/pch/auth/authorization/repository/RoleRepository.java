package com.pch.auth.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pch.auth.authorization.model.po.RolePo;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleRepository extends JpaRepository<RolePo, Long> {
}
