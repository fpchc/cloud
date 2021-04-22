package com.pch.user.organization.repository;

import com.pch.user.organization.model.po.UserPo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserRepository extends JpaSpecificationExecutor<UserPo>,
        JpaRepository<UserPo, Integer> {

    Optional<UserPo> findByUsername(String username);
}
