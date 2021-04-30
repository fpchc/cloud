package com.pch.auth.authentication.repository;

import com.pch.auth.authentication.model.po.ResourcePo;
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
    List<ResourcePo> findByResourcesIds(@Param("resourceIds") List<Long> resourceIds);
}
