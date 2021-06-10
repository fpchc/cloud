package com.pch.common.config;

import com.pch.common.base.IdWorker;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
@Getter
@Setter
@AllArgsConstructor
public class SnowFlakeIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor,
            Object o) throws HibernateException {
        IdWorker idWorker = new IdWorker(1, 1, 1);
        return idWorker.nextId();
    }
}
