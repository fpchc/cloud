package com.pch.user.organization.repository;

import com.pch.user.organization.model.po.ResourcesPo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface PermissionRepository extends JpaRepository<ResourcesPo, Long> {

    @Query("select p from ResourcesPo p where p.id in (:permissionIds)")
    List<ResourcesPo> findByPermissionIds(@Param("permissionIds") List<Long> permissionIds);
}
