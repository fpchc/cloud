package com.pch.gateway.event;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.pch.gateway.model.domain.UserPo;
import com.pch.gateway.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2020-12-20 13:31
 */
@Slf4j
@Component
@Async("default")
public class UserEventListener {

    @Autowired
    private UserService userService;

    @EventListener
    public void userEvent(UserEvent event) {
        log.info("当前线程名称：{}", Thread.currentThread().getName());
        Object source = event.getSource();
        userHandler(event.getUserDO(), event.getAction());
        System.out.println(source);
    }

    public void userHandler(UserPo userPo, String action) {
        if (StringUtils.equalsIgnoreCase(action, "insert")) {
            userService.saveOrUpdate(userPo);
        }
    }

}
