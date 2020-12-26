package com.pch.common.base;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

import lombok.AllArgsConstructor;

/**
 * @Author: pch
 * @Date: 2020/12/26 10:43
 */
@AllArgsConstructor
public class IdGenerator implements IdentifierGenerator {

    private final Integer workId;

    private final Integer datacenterId;

    @Override
    public Number nextId(Object entity) {
        IdWorker idWorker = new IdWorker(workId, datacenterId, 1);
        return idWorker.nextId();
    }
}
