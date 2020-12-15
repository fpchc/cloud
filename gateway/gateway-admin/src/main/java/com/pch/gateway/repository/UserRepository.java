package com.pch.gateway.repository;

import org.springframework.data.repository.CrudRepository;

import com.pch.gateway.model.domain.UserDO;

/**
 *
 * @Author: pch
 * @Date: 2020/12/15 15:58
 */
public interface UserRepository extends CrudRepository<UserDO, Long> {

}
