package com.pch.gateway.event;

import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.pch.common.constant.RabbitMQConstant;
import com.pch.gateway.model.domain.UserPo;
import com.pch.gateway.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: pch
 * @Date: 2020-12-20 13:31
 */
@Slf4j
@Async
@Component
@AllArgsConstructor
public class UserEventListener {

    private final UserService userService;
    private final RabbitTemplate rabbitTemplate;

    @EventListener
    public void userEvent(UserEvent event) {
        log.info("当前线程名称：{}", Thread.currentThread().getName());
        String action = (String) event.getSource();
        userHandler(event.getUserDO(), action);
    }

    public void userHandler(UserPo userPo, String action) {
        if (StringUtils.equalsIgnoreCase(action, "insert")) {
            boolean b = userService.saveOrUpdate(userPo);
            rabbitTemplate.convertAndSend(RabbitMQConstant.GATEWAY_EXCHANGE, RabbitMQConstant.MESSAGE_ROUTE_KEY, b ? "success" : "failed");
        }
    }

}
