package com.pch.auth.authorization.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pch.auth.authorization.model.domain.UserPo;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserRepository extends JpaSpecificationExecutor<UserPo>,
        JpaRepository<UserPo, Integer> {

    Optional<UserPo> findByUsername(String username);
}
