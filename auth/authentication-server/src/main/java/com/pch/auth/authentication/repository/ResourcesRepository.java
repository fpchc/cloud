package com.pch.auth.authentication.repository;

import com.pch.auth.authentication.model.po.ResourcesPo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface ResourcesRepository extends JpaRepository<ResourcesPo, Long> {

    @Query("select p from ResourcesPo p where p.id in (:resourcesList)")
    List<ResourcesPo> findByResourcesIds(@Param("permissionIds") List<Long> resourcesList);
}
