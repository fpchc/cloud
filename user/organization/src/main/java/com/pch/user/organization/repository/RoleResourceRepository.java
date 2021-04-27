package com.pch.user.organization.repository;

import com.pch.user.organization.model.po.RoleResourcePo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleResourceRepository extends JpaRepository<RoleResourcePo, Long> {

    @Query("select rp from RoleResourcePo rp where rp.roleId in (:roleIds)")
    List<RoleResourcePo> findByRoleIds(@Param("roleIds") List<Long> roleIds);
}
