package com.pch.user.organization.repository;

import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
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

    @Query("select p from ResourcePo p inner join RoleResourcePo re on re.resourceId = p.id "
            + "inner join UserRolePo ur on ur.roleId = re.roleId where ur.userId = #{userId}")
    List<ResourcePo> findByUserId(@Param("userId") Long userId);
}
