package com.pch.common.constant;

/**
 * <P> rabbitmq 队列 交换机 route key 常量 </P>
 *
 * @Author: pch
 * @Date: 2021/01/05 9:18
 */
public interface RabbitMQConstant {

    String GATEWAY_QUEUE = "gateway.queue";
    String MESSAGE_QUEUE = "message.queue";
    String GATEWAY_EXCHANGE = "gatewayExchange";
    String GATEWAY_ROUTE_KEY = "topic.route.gateway";
    String MESSAGE_ROUTE_KEY = "topic.route.message";
}
