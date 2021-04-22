package com.pch.auth.authentication.repository;

import com.pch.auth.authentication.model.po.RolePermissionPo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RolePermissionRepository extends JpaRepository<RolePermissionPo, Long> {

    @Query("select rp from RolePermissionPo rp where rp.roleId in (:roleIds)")
    List<RolePermissionPo> findByRoleIds(@Param("roleIds") List<Long> roleIds);
}
