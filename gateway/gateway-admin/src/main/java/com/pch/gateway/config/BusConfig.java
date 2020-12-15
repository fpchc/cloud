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

    public static final String GATEWAY_ROUTE_QUEUE = "gateway_route_queue";
    public static final String ROUTE_EXCHANGE = "route_exchange";
    public static final String GATEWAY_ROUTE_KEY = "gateway_route_key";

    @Bean
    Queue routeQueue() {
        return new Queue(BusConfig.GATEWAY_ROUTE_QUEUE);
    }

    @Bean
    TopicExchange routeTopicExchange() {
        return new TopicExchange(BusConfig.ROUTE_EXCHANGE);
    }

    @Bean
    Binding binding(Queue routeQueue, TopicExchange routeTopicExchange) {
        return BindingBuilder.bind(routeQueue).to(routeTopicExchange).with(BusConfig.GATEWAY_ROUTE_KEY);
    }

}
