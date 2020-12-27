package com.pch.gateway.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * <P> bus 消息总站 </P>
 *
 * @Author: pch
 * @Date: 2020/12/13 18:01
 */
@Configurable
public class BusConfig {

    public static final String GATEWAY_QUEUE = "gatewayQueue";
    public static final String GATEWAY_EXCHANGE = "gatewayExchange";
    public static final String TOPIC_MESSAGE = "topic.message";

    @Bean
    public Queue gatewayQueue() {
        return new Queue(BusConfig.GATEWAY_QUEUE);
    }

    @Bean
    public TopicExchange routeTopicExchange() {
        return new TopicExchange(BusConfig.GATEWAY_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue gatewayQueue, TopicExchange routeTopicExchange) {
        return BindingBuilder.bind(gatewayQueue).to(routeTopicExchange).with(BusConfig.TOPIC_MESSAGE);
    }

}
