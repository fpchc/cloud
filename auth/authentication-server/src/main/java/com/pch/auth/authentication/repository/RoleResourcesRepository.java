package com.pch.auth.authentication.repository;

import com.pch.auth.authentication.model.po.RoleResourcesPo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleResourcesRepository extends JpaRepository<RoleResourcesPo, Long> {

    @Query("select rp from RoleResourcesPo rp where rp.roleId in (:roleIds)")
    List<RoleResourcesPo> findByRoleIds(@Param("roleIds") List<Long> roleIds);
}
