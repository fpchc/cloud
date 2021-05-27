package com.pch.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @Author: pch
 * @Date: 2021/5/24 10:29
 */
@Slf4j
public class AuditorMetaObjectHandler implements MetaObjectHandler {

    private static final String DEFAULT_USERNAME = "system";

    public String getUsername() {
        return StringUtils.defaultIfBlank(UserContextHolder.getUsername(), DEFAULT_USERNAME);
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createdTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createdBy", String.class, getUsername());
        this.strictInsertFill(metaObject, "updatedBy", String.class, getUsername());
        this.strictInsertFill(metaObject, "updatedTime", LocalDateTime.class, LocalDateTime.now());
        log.info("end insert fill ....");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updatedBy", String.class, getUsername());
        log.info("end update fill ....");
    }
}
