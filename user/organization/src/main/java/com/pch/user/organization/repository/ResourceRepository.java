package com.pch.user.organization.repository;

import com.pch.user.organization.model.po.ResourcePo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface ResourceRepository extends JpaRepository<ResourcePo, Long> {

    @Query("select p from ResourcePo p where p.id in (:resourceIds)")
    List<ResourcePo> findByPermissionIds(@Param("resourceIds") List<Long> resourceIds);
}
