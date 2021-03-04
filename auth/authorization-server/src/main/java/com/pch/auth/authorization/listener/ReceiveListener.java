package com.pch.auth.authorization.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.pch.auth.authorization.model.domain.UserPo;
import com.pch.common.constant.RabbitMQConstant;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> 接受 rabbit内容 <p/>
 *
 * @Author: pch
 * @Date: 2021/01/04 18:11
 */
@Slf4j
@Component
public class ReceiveListener {

    @RabbitHandler
    @RabbitListener(queues = { RabbitMQConstant.MESSAGE_QUEUE } )
    public void receive(UserPo userPo) {
        log.info("userPo : {}", userPo);
    }
}
