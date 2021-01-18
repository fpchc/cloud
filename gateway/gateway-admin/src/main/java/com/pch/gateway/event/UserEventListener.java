package com.pch.gateway.event;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.pch.common.constant.RabbitMQConstant;
import com.pch.common.exception.ServiceException;
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
        switch (action) {
            case "insert":
            case "update":
                boolean b = userService.saveOrUpdate(userPo);
                rabbitTemplate.convertAndSend(RabbitMQConstant.GATEWAY_EXCHANGE,
                        RabbitMQConstant.MESSAGE_ROUTE_KEY, userPo);
                break;
            default:
                log.error("userEvent action is not exist: {}", action);
                throw new ServiceException(10000L, "userEvent action不存在");
        }
    }

}
