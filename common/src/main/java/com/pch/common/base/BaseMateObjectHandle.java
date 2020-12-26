package com.pch.common.base;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2020/12/26 10:50
 */
@Slf4j
public class BaseMateObjectHandle implements MetaObjectHandler {

    public static final String DEFAULT_CREATE_BY = "system";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("start insert fill ....");
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createBy", String.class, DEFAULT_CREATE_BY);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("start update fill ....");
        // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "modifyTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "modifyBy", String.class, DEFAULT_CREATE_BY);
    }
}
