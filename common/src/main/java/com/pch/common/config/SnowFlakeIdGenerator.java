package com.pch.common.config;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.pch.common.base.IdWorker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
