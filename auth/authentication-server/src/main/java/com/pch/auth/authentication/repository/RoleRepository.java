package com.pch.auth.authentication.repository;

import com.pch.auth.authentication.model.po.RolePo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleRepository extends JpaRepository<RolePo, Long> {

}
