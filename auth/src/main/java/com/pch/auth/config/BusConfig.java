package com.pch.auth.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pch.common.constant.RabbitMQConstant;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> bus 配置 </p>
 * @Author: pch
 * @Date: 2021/01/04 18:09
 */
@Slf4j
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
        return BindingBuilder.bind(gatewayQueue).to(routeTopicExchange).with(RabbitMQConstant.GATEWAY_ROUTE_KEY);
    }

    @Bean
    public Binding messageBinding(Queue messageQueue, TopicExchange routeTopicExchange) {
        return BindingBuilder.bind(messageQueue).to(routeTopicExchange).with(RabbitMQConstant.MESSAGE_ROUTE_KEY);
    }
}