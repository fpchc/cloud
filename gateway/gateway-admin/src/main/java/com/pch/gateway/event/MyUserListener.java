package com.pch.gateway.event;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
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
public class MyUserListener implements ApplicationListener<UserEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(UserEvent event) {
        log.info("当前线程名称：{}", Thread.currentThread().getName());
        Object source = event.getSource();
        userHandler(event.getUserDO(), event.getAction());
        System.out.println(source);
    }

    @Async
    public void userHandler(UserPo userPo, String action) {
        if (StringUtils.equalsIgnoreCase(action, "insert")) {
            userService.insert(userPo);
        }
    }

}
