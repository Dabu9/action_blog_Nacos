package com.damaha.actionblog.sms.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置文件【可用于自动生成队列和交换机】
 */
@Configuration
public class RabbitMqConfig {
    // 队列
    public static final String ACTION_BLOG = "action.blog";
    public static final String ACTION_EMAIL = "action.email";
    public static final String ACTION_SMS = "action.sms";
    // 交换机
    public static final String EXCHANGE_DIRECT = "exchange.direct";
    // Key
    public static final String ROUTING_KEY_BLOG = "action.blog";
    public static final String ROUTING_KEY_EMAIL = "action.email";
    public static final String ROUTING_KEY_SMS = "action.sms";

    /**
     * 声明交换机
     */
    @Bean(EXCHANGE_DIRECT)
    public Exchange EXCHANGE_DIRECT() {
        // 声明路由交换机，durable:在rabbitmq重启后，交换机还在
        return ExchangeBuilder
                .directExchange(EXCHANGE_DIRECT)
                .durable(true)
                .build();
    }

    /**
     * 声明Blog队列
     *
     * @return
     */
    @Bean(ACTION_BLOG)
    public Queue ACTION_BLOG() {
        return new Queue(ACTION_BLOG);
    }

    /**
     * 声明Email队列
     *
     * @return
     */
    @Bean(ACTION_EMAIL)
    public Queue ACTION_EMAIL() {
        return new Queue(ACTION_EMAIL);
    }

    /**
     * 声明SMS队列
     *
     * @return
     */
    @Bean(ACTION_SMS)
    public Queue ACTION_SMS() {
        return new Queue(ACTION_SMS);
    }

    /**
     * action.blog 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_BLOG(
            @Qualifier(ACTION_BLOG) Queue queue,
            @Qualifier(EXCHANGE_DIRECT) Exchange exchange
    ) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY_BLOG)
                .noargs();
    }

    /**
     * action.mail 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(
            @Qualifier(ACTION_EMAIL) Queue queue,
            @Qualifier(EXCHANGE_DIRECT) Exchange exchange
    ) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY_EMAIL)
                .noargs();
    }

    /**
     * action.sms 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(
            @Qualifier(ACTION_SMS) Queue queue,
            @Qualifier(EXCHANGE_DIRECT) Exchange exchange
    ) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY_SMS)
                .noargs();
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
