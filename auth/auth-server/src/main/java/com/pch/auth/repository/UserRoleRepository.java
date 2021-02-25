package com.pch.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pch.auth.model.domain.UserRolePo;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface UserRoleRepository extends JpaRepository<UserRolePo, Long> {

    List<UserRolePo> findByUserId(Long userId);
}
