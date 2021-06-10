package com.pch.auth.authorization.repository;

import com.pch.auth.authorization.model.po.RolePo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleRepository extends JpaRepository<RolePo, Long> {

}
