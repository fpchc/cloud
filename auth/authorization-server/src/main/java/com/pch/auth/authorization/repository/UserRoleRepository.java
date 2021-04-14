package com.pch.auth.authorization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pch.auth.authorization.model.po.UserRolePo;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface UserRoleRepository extends JpaRepository<UserRolePo, Long> {

    List<UserRolePo> findByUserId(Long userId);
}
