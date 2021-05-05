package com.pch.auth.authorization.repository;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.pch.auth.authorization.model.po.UserPo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
public interface UserRepository extends JpaSpecificationExecutor<UserPo>,
        JpaRepository<UserPo, Integer> {

    @Cached(name = "user", cacheType = CacheType.REMOTE)
    Optional<UserPo> findByUsername(String username);
}
