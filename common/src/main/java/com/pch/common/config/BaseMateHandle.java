package com.pch.common.config;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * @Author: admin
 * @Date: 2020/12/25 11:54
 */
public class BaseMateHandle implements MetaObjectHandler {

    public static final String DEFAULT_CREATE_BY = "system";

    @Override
    public void insertFill(MetaObject metaObject) {
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        // todo 未完成
        this.strictInsertFill(metaObject, "createBy", String.class, DEFAULT_CREATE_BY);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "modifyTime", LocalDateTime.class, LocalDateTime.now());
        // todo 未完成
        this.strictInsertFill(metaObject, "modifyBy", String.class, DEFAULT_CREATE_BY);

    }
}
