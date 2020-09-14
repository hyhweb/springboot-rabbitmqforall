package com.springboot.rabbitmqprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Create by hyhweb on 2020/9/14 9:51
 * 主题交换机
 */
@Configuration
public class DirectRabbitConfig {
    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }
    @Bean
    DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange", true, false);
    }
    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }
    @Bean
    DirectExchange lonelyDirectExchange(){
        return new DirectExchange("lonelyDirectExchange");
    }
}
