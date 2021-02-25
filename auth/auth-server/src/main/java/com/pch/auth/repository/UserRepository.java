package com.pch.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pch.auth.model.domain.UserPo;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserRepository extends JpaSpecificationExecutor<UserPo>,
        JpaRepository<UserPo, Integer> {

    UserPo findByUsername(String username);
}
