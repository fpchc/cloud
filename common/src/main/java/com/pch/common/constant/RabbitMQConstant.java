package com.pch.common.constant;

/**
 * <P> rabbitmq 队列 交换机 route key 常量 </P>
 *
 * @Author: pch
 * @Date: 2021/01/05 9:18
 */
public interface RabbitMQConstant {

    String GATEWAY_QUEUE = "gateway.*";
    String MESSAGE_QUEUE = "gateway.message";
    String GATEWAY_EXCHANGE = "gatewayExchange";
    String TOPIC_GATEWAY = "topic.gateway";
    String TOPIC_MESSAGE = "topic.message";
}
