package com.pch.gateway.event;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.pch.gateway.config.BusConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * <P> rabbit 接收者 </P>
 * @Author: pch
 * @Date: 2020/12/27 17:38
 */
@Slf4j
@Component
public class RabbitReceive {

    @RabbitHandler
    @RabbitListener(queues = {BusConfig.GATEWAY_QUEUE})
    public void userInsertReceive(String object) {
        log.info("user insert receive: {}", object);
    }

}
