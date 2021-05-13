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

    @Query("select p from ResourcePo p inner join RoleResourcePo re on re.resourceId = p.id "
            + "inner join UserRolePo ur on ur.roleId = re.roleId where ur.userId = :userId")
    List<ResourcePo> findByUserId(@Param("userId") Long userId);

    @Query("select p from ResourcePo p "
            + "inner join RoleResourcePo re on re.resourceId = p.id "
            + "inner join UserRolePo ur on ur.roleId = re.roleId "
            + "inner join UserPo u on u.id = ur.userId "
            + "where u.username = :username order by p.id")
    List<ResourcePo> findByUsername(String username);
}
