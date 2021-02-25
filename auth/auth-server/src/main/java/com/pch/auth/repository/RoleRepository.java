package com.pch.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pch.auth.model.domain.RolePo;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleRepository extends JpaRepository<RolePo, Long> {
}
