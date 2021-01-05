package com.pch.gateway.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pch.common.constant.RabbitMQConstant;

/**
 * <P> bus 消息总站 </P>
 *
 * @Author: pch
 * @Date: 2020/12/13 18:01
 */
@Configuration
public class BusConfig {

    @Bean
    public Queue gatewayQueue() {
        return new Queue(RabbitMQConstant.GATEWAY_QUEUE);
    }

    @Bean
    public Queue messageQueue() {
        return new Queue(RabbitMQConstant.MESSAGE_QUEUE);
    }

    @Bean
    public TopicExchange routeTopicExchange() {
        return new TopicExchange(RabbitMQConstant.GATEWAY_EXCHANGE);
    }

    @Bean
    public Binding gatewayBinding(Queue gatewayQueue, TopicExchange routeTopicExchange) {
        return BindingBuilder.bind(gatewayQueue).to(routeTopicExchange).with(RabbitMQConstant.TOPIC_GATEWAY);
    }

    @Bean
    public Binding messageBinding(Queue messageQueue, TopicExchange routeTopicExchange) {
        return BindingBuilder.bind(messageQueue).to(routeTopicExchange).with(RabbitMQConstant.TOPIC_MESSAGE);
    }

}
