package com.pch.gateway.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <P> bus 消息总站 </P>
 *
 * @Author: pch
 * @Date: 2020/12/13 18:01
 */
@Configuration
public class BusConfig {

    public static final String GATEWAY_QUEUE = "gateway.*";
    public static final String MESSAGE_QUEUE = "gateway.message";
    public static final String GATEWAY_EXCHANGE = "gatewayExchange";
    public static final String TOPIC_GATEWAY = "topic.gateway";
    public static final String TOPIC_MESSAGE = "topic.message";

    @Bean
    public Queue gatewayQueue() {
        return new Queue(BusConfig.GATEWAY_QUEUE);
    }

    @Bean
    public Queue messageQueue() {
        return new Queue(BusConfig.MESSAGE_QUEUE);
    }

    @Bean
    public TopicExchange routeTopicExchange() {
        return new TopicExchange(BusConfig.GATEWAY_EXCHANGE);
    }

    @Bean
    public Binding gatewayBinding(Queue gatewayQueue, TopicExchange routeTopicExchange) {
        return BindingBuilder.bind(gatewayQueue).to(routeTopicExchange).with(BusConfig.TOPIC_GATEWAY);
    }

    @Bean
    public Binding messageBinding(Queue messageQueue, TopicExchange routeTopicExchange) {
        return BindingBuilder.bind(messageQueue).to(routeTopicExchange).with(BusConfig.TOPIC_GATEWAY);
    }

}
