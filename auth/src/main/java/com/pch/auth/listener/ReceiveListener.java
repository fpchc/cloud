package com.pch.auth.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.pch.auth.config.BusConfig;

/**
 * <p> 接受 rabbit内容 <p/>
 * @Author: admin
 * @Date: 2021/01/04 18:11
 */
@Component
public class ReceiveListener {

    @RabbitHandler
    @RabbitListener(queues = { BusConfig.GATEWAY_QUEUE })
    public void receive(Object obj) {
        System.out.println(obj);
    }
}
