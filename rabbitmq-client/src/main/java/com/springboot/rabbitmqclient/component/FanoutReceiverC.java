package com.springboot.rabbitmqclient.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Create by hyhweb on 2020/9/14 15:11
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {
    @RabbitHandler
    public void process(Map message) {
        System.out.println("FanoutReceiverC消费者收到消息："+message.toString());
    }

}
